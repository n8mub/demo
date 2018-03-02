package com.accenture.cwr37.dynamodb;

import java.math.BigDecimal;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import com.amazonaws.services.dynamodbv2.model.Select;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

public class SaveDynamoDBHandler implements RequestHandler<DynamoDBRequest, DynamoDBResponse> {
	private DynamoDB dynamoDb;
	private AmazonDynamoDB dynamoDBClient;
	private static final Regions REGION = Regions.US_EAST_1;

	private static final String ADD = "add";
	private static final String RETRIEVE = "retrieve";
	private static final String COUNT = "count";

	public DynamoDBResponse handleRequest(DynamoDBRequest dynamoDBRequest, Context context) {

		this.initDynamoDbClient();

		DynamoDBResponse dynamoDBResponse = new DynamoDBResponse();
		try {
			if (StringUtils.equals(ADD, dynamoDBRequest.getOperation())) {
				dynamoDBRequest.setPayload(convertData(dynamoDBRequest));
				if (dataValid(dynamoDBRequest)) {
					dynamoDBRequest.persistData(dynamoDb);
					dynamoDBResponse.setMessage("Saved Successfully!!!");
					dynamoDBResponse.setPayload(dynamoDBRequest.getPayload());
				} else {
					dynamoDBResponse.setMessage("Invalid Data");
				}
			} else if (StringUtils.equals(RETRIEVE, dynamoDBRequest.getOperation())) {
				dynamoDBResponse.setPayload(getData(dynamoDBRequest));
				dynamoDBResponse.setMessage("Data Returned");
			} else if (StringUtils.equals(COUNT, dynamoDBRequest.getOperation())) {
				dynamoDBResponse.setMessage("Data Count Returned");
				dynamoDBResponse.setCount(countData(dynamoDBRequest));
			} else {
				dynamoDBResponse.setMessage("No such method");
				dynamoDBResponse.setJson(dynamoDBRequest.toString());
			}
		} catch (Exception e) {
			context.getLogger().log(e.getStackTrace().toString());
			dynamoDBResponse.setMessage(e.getMessage());
			dynamoDBResponse.setJson(dynamoDBRequest.toString());
		}

		return dynamoDBResponse;
	}

	private boolean dataValid(DynamoDBRequest dynamoDBRequest) {
		if (StringUtils.equals(Person.DYNAMODB_TABLE_NAME, dynamoDBRequest.getDynamoDBTableName())) {
			if (((Person) dynamoDBRequest.getPayload()).getAge() < 0) {
				return false;
			} else {
				return true;
			}
		} else {
			return true;
		}
	}

	private DynamoDBPayload convertData(DynamoDBRequest dynamoDBRequest) {
		Map<String, Object> map = dynamoDBRequest.getObjectMap();
		if (StringUtils.equals(Person.DYNAMODB_TABLE_NAME, dynamoDBRequest.getDynamoDBTableName())) {
			Person person = new Person();
			person.setId(Integer.valueOf(((Integer) map.get("id")).intValue()));
			person.setFirstName(map.get("firstName").toString());
			person.setLastName(map.get("lastName").toString());
			person.setAge(Integer.valueOf(((Integer) map.get("age")).intValue()));
			person.setAddress(map.get("address").toString());
			return person;
		} else {
			return null;
		}
	}

	private DynamoDBPayload getData(DynamoDBRequest dynamoDBRequest) {
		Item item = dynamoDb.getTable(dynamoDBRequest.getDynamoDBTableName()).getItem("id",
				Integer.valueOf(dynamoDBRequest.getObjectMap().get("id").toString()));
		if (StringUtils.equals(Person.DYNAMODB_TABLE_NAME, dynamoDBRequest.getDynamoDBTableName())) {
			Person person = new Person();
			person.setId(Integer.valueOf(((BigDecimal) item.get("id")).intValue()));
			person.setFirstName(item.get("firstName").toString());
			person.setLastName(item.get("lastName").toString());
			person.setAge(Integer.valueOf(((BigDecimal) item.get("age")).intValue()));
			person.setAddress(item.get("address").toString());
			return person;
		} else {
			return null;
		}
	}

	private Integer countData(DynamoDBRequest dynamoDBRequest) {
		ScanRequest scanRequest = new ScanRequest(dynamoDBRequest.getDynamoDBTableName());
		scanRequest.setSelect(Select.COUNT);
		ScanResult scanResult = dynamoDBClient.scan(scanRequest);
		return scanResult.getCount();
	}

	private void initDynamoDbClient() {
		dynamoDBClient = AmazonDynamoDBClientBuilder.standard().withRegion(REGION).build();
		this.dynamoDb = new DynamoDB(dynamoDBClient);
	}

}
