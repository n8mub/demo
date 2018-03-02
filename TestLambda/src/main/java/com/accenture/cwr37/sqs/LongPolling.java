/*
 * Copyright 2011-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at:
 *
 *    http://aws.amazon.com/apache2.0
 *
 * This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES
 * OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and
 * limitations under the License.
 */
package com.accenture.cwr37.sqs;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.AmazonSQSException;
import com.amazonaws.services.sqs.model.CreateQueueRequest;
import com.amazonaws.services.sqs.model.SetQueueAttributesRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;

public class LongPolling {
	public void longPolling(String queue_name, String queue_url) {
		AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();
		// Enable long polling when creating a queue
        CreateQueueRequest create_request = new CreateQueueRequest()
                .withQueueName(queue_name)
                .addAttributesEntry("ReceiveMessageWaitTimeSeconds", "20");

        try {
            sqs.createQueue(create_request);
        } catch (AmazonSQSException e) {
            if (!e.getErrorCode().equals("QueueAlreadyExists")) {
                throw e;
            }
        }

        // Enable long polling on an existing queue
        SetQueueAttributesRequest set_attrs_request = new SetQueueAttributesRequest()
                .withQueueUrl(queue_url)
                .addAttributesEntry("ReceiveMessageWaitTimeSeconds", "20");
        sqs.setQueueAttributes(set_attrs_request);

        // Enable long polling on a message receipt
        ReceiveMessageRequest receive_request = new ReceiveMessageRequest()
                .withQueueUrl(queue_url)
                .withWaitTimeSeconds(20);
        sqs.receiveMessage(receive_request);
	}

}
