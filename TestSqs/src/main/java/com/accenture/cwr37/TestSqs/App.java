package com.accenture.cwr37.TestSqs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.IOUtils;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.ListQueuesResult;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageBatchRequest;
import com.amazonaws.services.sqs.model.SendMessageBatchRequestEntry;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("AWScredentials.properties"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace(System.err);
		} catch (IOException e1) {
			e1.printStackTrace(System.err);
		}
		String accessKey = properties.getProperty("accessKey");
		String secretKey = properties.getProperty("secretKey");
		AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
		AWSCredentialsProvider credentialsProvider = new AWSStaticCredentialsProvider(credentials);
		
		AmazonSQS sqs = AmazonSQSClientBuilder.standard()
				.withRegion(Regions.US_EAST_1)
				.withCredentials(credentialsProvider)
				.build();
		
		String requestForFirst = "", requestForSecond = "";
		JsonArray notifyarray = new JsonArray();
		JsonParser parser = new JsonParser();
		JsonObject reportjson = null;
		try {
			requestForFirst = IOUtils.toString(new FileInputStream("src/main/resources/RequestForFirst.json"));
			requestForSecond = IOUtils.toString(new FileInputStream("src/main/resources/RequestForSecond.json"));
			JsonElement first = parser.parse(requestForFirst);
			if(first instanceof JsonArray) {
				notifyarray.addAll((JsonArray) first);
			} else {
				notifyarray.add(first);
			}
			JsonElement second = parser.parse(requestForSecond);
			if(second instanceof JsonObject) {
				reportjson = (JsonObject) second;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace(System.err);
		} catch (IOException e) {
			e.printStackTrace(System.err);
		} catch (JsonSyntaxException e) {
			e.printStackTrace(System.err);
		} catch (ClassCastException e) {
			e.printStackTrace(System.err);
		} catch (Exception e) {
			e.printStackTrace(System.err);
		} finally {
			if(reportjson == null) {
				reportjson = new JsonObject();
			}
		}
		List<SendMessageBatchRequestEntry> notifyenteries = new ArrayList<SendMessageBatchRequestEntry>();
		for(int i = 0;i < notifyarray.size();i++) {
			if(notifyarray.get(i) instanceof JsonObject) {
				JsonObject obj = (JsonObject) notifyarray.get(i);
				notifyenteries.add(new SendMessageBatchRequestEntry("msg_"+i, obj.toString()).withDelaySeconds(0));
			}
		}
//		String queue_url = "https://sqs.us-east-2.amazonaws.com/290224558039/tfr-dev_sqs.fifo";
		SendMessageBatchRequest send_notify_batch_msg_request = new SendMessageBatchRequest()
				.withQueueUrl(sqs.getQueueUrl("NotifyQueue").getQueueUrl())
				.withEntries(notifyenteries);
		sqs.sendMessageBatch(send_notify_batch_msg_request);
		SendMessageRequest send_notify_msg_request = new SendMessageRequest()
				.withQueueUrl(sqs.getQueueUrl("NotifyQueue").getQueueUrl())
				.withMessageBody(notifyarray.toString())
				.withDelaySeconds(0);
		sqs.sendMessage(send_notify_msg_request);
		SendMessageRequest send_report_msg_request = new SendMessageRequest()
				.withQueueUrl(sqs.getQueueUrl("ReportQueue").getQueueUrl())
				.withMessageBody(reportjson.toString())
				.withDelaySeconds(0);
		sqs.sendMessage(send_report_msg_request);
		ListQueuesResult lq_result = sqs.listQueues();
		System.out.println("Your SQS Queue URLs:");
		for (String url : lq_result.getQueueUrls()) {
			System.out.println(url);
			ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(url).withMessageAttributeNames("All").withAttributeNames("All");
			for (Message message : sqs.receiveMessage(receiveMessageRequest).getMessages()) {
				System.out.println(message.getBody());
				sqs.deleteMessage(url, message.getReceiptHandle());
			}
		}
	}
}
