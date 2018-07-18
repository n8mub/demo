package com.comerica.tfr.notify.endpoint;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.PropertiesFileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import com.amazonaws.services.sqs.model.SendMessageBatchRequest;
import com.amazonaws.services.sqs.model.SendMessageBatchRequestEntry;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.comerica.tfr.commons.exception.TFRException;
import com.comerica.tfr.notify.service.NotifyServiceImpl;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import junit.framework.TestCase;

//@RunWith(MockitoJUnitRunner.class)
public class NotifyEndpointTest extends TestCase {
	
	private NotifyEndpoint notifyEndpoint = new NotifyEndpoint();
	
	List<Message> notifty_messages;
	List<Message> report_messages;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		notifyEndpoint.notifyService = new NotifyServiceImpl();
		notifyEndpoint.pooling_for_messages = false;
//		notifyEndpoint.sqs = Mockito.mock(AmazonSQS.class);
		AWSCredentialsProvider credentials = new PropertiesFileCredentialsProvider("AWScredentials.properties");
		notifyEndpoint.sqs = AmazonSQSClientBuilder.standard()
		.withRegion(Regions.US_EAST_1)
		.withCredentials(credentials)
		.build();
		
		notifty_messages = new ArrayList<Message>();
		JsonArray notifyarray = new JsonArray(); 
		JsonObject notify1 = new JsonObject();
		notify1.addProperty("fileId", "BAI2.AXSBAI2");
		notify1.addProperty("unitOfWorkId", 6697);
		JsonObject notify2 = new JsonObject();
		notify2.addProperty("fileId", "BAI2.CD401");
		notify2.addProperty("unitOfWorkId", 61);
		JsonArray accounts = new JsonArray();
		JsonObject account1 = new JsonObject();
		account1.addProperty("customerAccountNumber", "1840001174");
		account1.addProperty("abaRoutingNumber", "072000096");
		JsonObject account2 = new JsonObject();
		account2.addProperty("customerAccountNumber", "1840001174");
		account2.addProperty("abaRoutingNumber", "111000753");
		accounts.add(account1);
		accounts.add(account2);
		notify2.add("accounts", accounts);
		notifyarray.add(notify1);
		notifyarray.add(notify2);
		for(JsonElement element : notifyarray) {
			notifty_messages.add(new Message().withBody(element.toString()));
		}
		notifty_messages.add(new Message().withBody(notifyarray.toString()));
		
		report_messages = new ArrayList<Message>();
		JsonObject report1 = new JsonObject();
		report1.addProperty("success", true);
		JsonObject data = new JsonObject();
		data.addProperty("type", "processedReportDataBean");
		data.addProperty("processedReportId", 643);
		report1.add("data", data);
		report_messages.add(new Message().withBody(report1.toString()));
		
		//sendMessages();
	}

	@Test
	public void testAddNotifications() throws TFRException {
		String notify_queue_name = "NotifyQueue";
		String notify_queue_url = "https://sqs.us-east-2.amazonaws.com/NotifyQueue";
//		Mockito.when(notifyEndpoint.sqs.getQueueUrl(Mockito.anyString())).thenReturn(Mockito.mock(GetQueueUrlResult.class));
//		Mockito.when(notifyEndpoint.sqs.getQueueUrl(notify_queue_name).getQueueUrl()).thenReturn(notify_queue_url);
//		Mockito.when(notifyEndpoint.sqs.receiveMessage(Mockito.any(ReceiveMessageRequest.class))).thenReturn(Mockito.mock(ReceiveMessageResult.class));
//		Mockito.when(notifyEndpoint.sqs.receiveMessage(Mockito.any(ReceiveMessageRequest.class)).getMessages()).thenReturn(notifty_messages);
		assertTrue(notifyEndpoint.addNotifications());
	}

	@Test
	public void testReportStatusNotification() throws TFRException {
		String report_queue_name = "ReportQueue";
		String report_queue_url = "https://sqs.us-east-2.amazonaws.com/ReportQueue";
//		Mockito.when(notifyEndpoint.sqs.getQueueUrl(Mockito.anyString())).thenReturn(Mockito.mock(GetQueueUrlResult.class));
//		Mockito.when(notifyEndpoint.sqs.getQueueUrl(report_queue_name).getQueueUrl()).thenReturn(report_queue_url);
//		Mockito.when(notifyEndpoint.sqs.receiveMessage(Mockito.any(ReceiveMessageRequest.class))).thenReturn(Mockito.mock(ReceiveMessageResult.class));
//		Mockito.when(notifyEndpoint.sqs.receiveMessage(Mockito.any(ReceiveMessageRequest.class)).getMessages()).thenReturn(report_messages);
		assertTrue(notifyEndpoint.reportStatusNotification());
	}
	
	public void sendMessages() {
		List<SendMessageBatchRequestEntry> notifyenteries = new ArrayList<SendMessageBatchRequestEntry>();
		for(int i = 0;i < notifty_messages.size();i++) {
			Message message = notifty_messages.get(i);
			notifyenteries.add(new SendMessageBatchRequestEntry("msg_"+i, message.getBody()).withDelaySeconds(0));
		}
		SendMessageBatchRequest send_notify_batch_msg_request = new SendMessageBatchRequest()
				.withQueueUrl(notifyEndpoint.sqs.getQueueUrl("NotifyQueue").getQueueUrl())
				.withEntries(notifyenteries);
		notifyEndpoint.sqs.sendMessageBatch(send_notify_batch_msg_request);
		
		SendMessageRequest send_report_msg_request = new SendMessageRequest()
				.withQueueUrl(notifyEndpoint.sqs.getQueueUrl("ReportQueue").getQueueUrl())
				.withMessageBody(report_messages.get(0).getBody())
				.withDelaySeconds(0);
		notifyEndpoint.sqs.sendMessage(send_report_msg_request);
	}

}
