package com.comerica.tfr.notify.endpoint;

import java.util.List;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.comerica.tfr.commons.exception.TFRException;
import com.comerica.tfr.data.beans.ProcessedReportDataBean;
import com.comerica.tfr.notify.bean.NotificationBean;
import com.comerica.tfr.notify.service.NotifyService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class NotifyEndpoint {
	private static final String INTERNAL_SERVER_ERROR = "Internal server error occured while saving notifications";

	public NotifyService notifyService;
	public AmazonSQS sqs = AmazonSQSClientBuilder.standard().withRegion(Regions.US_EAST_2).build();
	public boolean pooling_for_messages = true;

	public boolean addNotifications() throws TFRException {
		String queue_name = "NotifyQueue";
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		String url = sqs.getQueueUrl(queue_name).getQueueUrl();
		boolean return_value = false;
		do {
			try {
				ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(url)
						.withAttributeNames("All").withMessageAttributeNames("All")
						.withMaxNumberOfMessages(10).withWaitTimeSeconds(20);
				List<Message> messages = sqs.receiveMessage(receiveMessageRequest).getMessages();
				for (Message message : messages) {
					JsonElement element = parser.parse(message.getBody());
					if (element instanceof JsonArray) {
						NotificationBean[] notifications = gson.fromJson(element, NotificationBean[].class);
						notifyService.addNotifications(notifications);
					} else if (element instanceof JsonObject) {
						NotificationBean notification = gson.fromJson(element, NotificationBean.class);
						notifyService.addNotifications(notification);
					}
					sqs.deleteMessage(url, message.getReceiptHandle());
					return_value = true;
				}
				return_value = !messages.isEmpty();
			} catch (TFRException ex) {
				System.err.println(INTERNAL_SERVER_ERROR);
				ex.printStackTrace(System.err);
			}
		} while (pooling_for_messages);
		return return_value;
	}

	public boolean reportStatusNotification() throws TFRException {
		String queue_name = "ReportQueue";
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		String url = sqs.getQueueUrl(queue_name).getQueueUrl();
		boolean return_value = false;
		do {
			try {
				ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(url)
						.withMessageAttributeNames("All").withAttributeNames("All")
						.withMaxNumberOfMessages(10).withWaitTimeSeconds(20);
				List<Message> messages = sqs.receiveMessage(receiveMessageRequest).getMessages();
				for (Message message : messages) {
					JsonElement element = parser.parse(message.getBody());
					if (element instanceof JsonObject) {
						JsonObject obj = (JsonObject) element;
						ProcessedReportDataBean processedReportDataBean = gson.fromJson(obj.get("data"),
								ProcessedReportDataBean.class);
						notifyService.saveReportFile(processedReportDataBean);
						sqs.deleteMessage(url, message.getReceiptHandle());
						return_value = true;
					}
				}
			} catch (TFRException ex) {
				System.err.println(INTERNAL_SERVER_ERROR);
				ex.printStackTrace(System.err);
			}
		} while (pooling_for_messages);
		return return_value;
	}
}
