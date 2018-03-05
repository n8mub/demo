package com.accenture.cwr37.TestSqs;

import java.util.HashMap;
import java.util.Map;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.PropertiesFileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import com.amazonaws.services.sqs.model.ListQueuesResult;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.MessageAttributeValue;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageRequest;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		AWSCredentialsProvider credentials = new PropertiesFileCredentialsProvider("AWScredentials.properties");
		AmazonSQS sqs = AmazonSQSClientBuilder.standard()
				.withRegion(Regions.US_EAST_1)
				.withCredentials(credentials)
				.build();
		String queue_name = "TestQueue";
		GetQueueUrlResult queueUrlResult = sqs.getQueueUrl(queue_name);
		Map<String, MessageAttributeValue> messageAttributes = new HashMap<String, MessageAttributeValue>();
		messageAttributes.put("id",new MessageAttributeValue()
				.withDataType("Number")
				.withStringValue(Integer.toString(1)));
		messageAttributes.put("firstName", new MessageAttributeValue()
				.withDataType("String")
				.withStringValue("John"));
		messageAttributes.put("lastName", new MessageAttributeValue()
				.withDataType("String")
				.withStringValue("Doe"));
		messageAttributes.put("age", new MessageAttributeValue()
				.withDataType("Number")
				.withStringValue(Integer.toString(30)));
		messageAttributes.put("address", new MessageAttributeValue()
				.withDataType("String")
				.withStringValue("United States"));
		StringBuilder builder = new StringBuilder();

		builder.append("{");
		builder.append(System.lineSeparator());
		for (String key : messageAttributes.keySet()) {
			builder.append(key);
			builder.append("=");
			builder.append("{");
			builder.append(messageAttributes.get(key).getDataType());
			builder.append(": ");
			builder.append(messageAttributes.get(key).getStringValue());
			builder.append("}");
			builder.append(",");
			builder.append(System.lineSeparator());
		}
		builder.append("}");
		SendMessageRequest send_msg_request = new SendMessageRequest()
				.withQueueUrl(queueUrlResult.getQueueUrl())
				.withMessageBody(builder.toString())
				.withMessageAttributes(messageAttributes)
				.withDelaySeconds(0);
		sqs.sendMessage(send_msg_request);
		ListQueuesResult lq_result = sqs.listQueues();
		System.out.println("Your SQS Queue URLs:");
		for (String url : lq_result.getQueueUrls()) {
			System.out.println(url);
			ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(url).withMessageAttributeNames("All").withAttributeNames("All");
			for (Message message : sqs.receiveMessage(receiveMessageRequest).getMessages()) {
				Map<String, MessageAttributeValue> map = message.getMessageAttributes();
				System.out.println("{");
				for (String key : map.keySet()) {
					System.out.print(key);
					System.out.print("=");
					System.out.print(map.get(key).getStringValue());
					System.out.println(",");
				}
				System.out.println("}");
				System.out.println(message.getBody());
				sqs.deleteMessage(url, message.getReceiptHandle());
			}
		}
	}
}
