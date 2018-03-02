package com.accenture.cwr37.TestSqs;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.PropertiesFileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.ListQueuesResult;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.SendMessageRequest;

/**
 * Hello world!
 *
 */
public class App {
	
	public static void main(String[] args) {
		AWSCredentialsProvider credentials = new PropertiesFileCredentialsProvider("AWScredentials.properties");
		AmazonSQS sqs = AmazonSQSClientBuilder.standard().withRegion(Regions.US_EAST_1).withCredentials(credentials).build();
		
		ListQueuesResult lq_result = sqs.listQueues();
		System.out.println("Your SQS Queue URLs:");
		for (String url : lq_result.getQueueUrls()) {
			System.out.println(url);
			SendMessageRequest send_msg_request = new SendMessageRequest()
					.withQueueUrl(url)
					.withMessageBody("Hello from Java")
					.withDelaySeconds(0);
			sqs.sendMessage(send_msg_request);
			for(Message message :sqs.receiveMessage(url).getMessages()) {
				System.out.println(message.getBody());
				sqs.deleteMessage(url, message.getReceiptHandle());
			}
		}
	}
}
