package com.accenture.cwr37.dynamodb;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;

public interface DynamoDBPayload {
	public int getId();
	public PutItemOutcome persistData(DynamoDB dynamoDb) throws ConditionalCheckFailedException;

}
