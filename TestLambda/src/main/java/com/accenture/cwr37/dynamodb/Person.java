package com.accenture.cwr37.dynamodb;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.spec.PutItemSpec;
import com.amazonaws.services.dynamodbv2.model.ConditionalCheckFailedException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Person implements DynamoDBPayload {
	public static final String DYNAMODB_TABLE_NAME = "Person";
	private int id;
	private String firstName;
    private String lastName;
    private int age;
    private String address;

    // standard getters and setters
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String toString() {
        final Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
	
	public PutItemOutcome persistData(DynamoDB dynamoDb) throws ConditionalCheckFailedException {
		return dynamoDb.getTable(DYNAMODB_TABLE_NAME).putItem(
        		new PutItemSpec().withItem(new Item().withInt("id", this.getId())
        				.withString("firstName", this.getFirstName())
        				.withString("lastName", this.getLastName())
        				.withInt("age", this.getAge())
        				.withString("address", this.getAddress())));
	}
	
}
