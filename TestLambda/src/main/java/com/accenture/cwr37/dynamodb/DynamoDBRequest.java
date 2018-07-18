package com.accenture.cwr37.dynamodb;

import java.util.Map;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class DynamoDBRequest {
	
	private String operation;
	private String dynamoDBTableName;
	private Map<String, Object> objectMap;
	private DynamoDBPayload payload;
	
    public String toString() {
        final Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
	
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getDynamoDBTableName() {
		return dynamoDBTableName;
	}
	public void setDynamoDBTableName(String dynamoDBTableName) {
		this.dynamoDBTableName = dynamoDBTableName;
	}
	public Map<String, Object> getObjectMap() {
		return objectMap;
	}
	public void setObjectMap(Map<String, Object> objectMap) {
		this.objectMap = objectMap;
	}
	public DynamoDBPayload getPayload() {
		return payload;
	}
	public void setPayload(DynamoDBPayload payload) {
		this.payload = payload;
	}
	public PutItemOutcome persistData(DynamoDB dynamoDb) throws ConditionalCheckFailedException {
		return payload.persistData(dynamoDb);
	}

}
