package com.accenture.cwr37.dynamodb;

import com.google.gson.Gson;

public class DynamoDBResponse {
	
	private String message;
	private String json;
	private int count;
	private DynamoDBPayload payload;

    public String toString() {
        final Gson gson = new Gson();
        return gson.toJson(this);
    }
	
	// standard getters and setters
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public DynamoDBPayload getPayload() {
		return payload;
	}
	public void setPayload(DynamoDBPayload payload) {
		this.payload = payload;
	}

}
