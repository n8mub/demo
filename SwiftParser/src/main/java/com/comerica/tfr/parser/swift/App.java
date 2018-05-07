package com.comerica.tfr.parser.swift;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import com.prowidesoftware.swift.model.SwiftMessage;
import com.prowidesoftware.swift.model.mt.mt9xx.MT940;
import com.prowidesoftware.swift.model.mt.mt9xx.MT942;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		List<File> files = (List<File>) FileUtils.listFiles(new File("Cma/tfr/scheduler/Globalscape"), new String[] { "out" }, false);
		System.out.println(files);
		for (File file : files) {
			System.out.println(file);
			try {
				String msg = FileUtils.readFileToString(file, "utf-8");
				String[] acks = StringUtils.split(msg, "$");
				for (String ack : acks) {
					SwiftMessage sm = SwiftMessage.parse(ack);
					
					String reportName = null;

					if (sm.isServiceMessage()) {

						SwiftMessage up = SwiftMessage.parse(sm.getUnparsedTexts().getAsFINString());

						System.out.println("Message Type: " + up.getType());

						if (up.isType(940)) {

							/*
							 * 
							 * Specialize the message to its specific model representation
							 * 
							 */

							MT940 mt = new MT940(up);

							/*
							 * 
							 * Print details of a specific field
							 * 
							 */

							System.out.println("Reference: " + mt.getApplicationId());
							System.out.println("Service: " + sm.getBlock1().getServiceId());
							String reference = mt.getSwiftMessage().getUserBlock("S").getTagValue("REF");
							reportName = Arrays.stream(reference.split("\\/")).limit(1).collect(Collectors.joining(""));
							System.out.println("Report Name: " + reportName);
							System.out.println("Seq num: " + mt.getSequenceNumber());
							System.out.println("Session num: " + mt.getSessionNumber());
							System.out.println("Ack: " + sm.isAck());
							System.out.println("Nack: " + sm.isNack());
							System.out.println("message: " + mt.message());

						} else if (up.isType(942)) {
							MT942 mt = new MT942(up);
							System.out.println("Reference: " + mt.getApplicationId());
							System.out.println("Service: " + sm.getBlock1().getServiceId());
							String reference = mt.getSwiftMessage().getUserBlock("S").getTagValue("REF");
							reportName = Arrays.stream(reference.split("\\/")).limit(1).collect(Collectors.joining(""));
							System.out.println("Report Name: " + reportName);
							System.out.println("Seq num: " + mt.getSequenceNumber());
							System.out.println("Session num: " + mt.getSessionNumber());
							System.out.println("Ack: " + sm.isAck());
							System.out.println("Nack: " + sm.isNack());
							System.out.println("message: " + mt.message());
						}
					}
					if(sm.isNack()) {
						List<String> reasons = sm.getBlock4().getTagByName("405").getField().getComponents(); 
						String reason = sm.getBlock4().getTagByName("405").getValue();
						System.out.println("Reason: " + reason);
						System.out.println(reasons);
						StringBuilder builder = new StringBuilder();
						builder.append("The following file did not transmitted successfully:");
                        builder.append(System.lineSeparator()).append(System.lineSeparator());
                        builder.append("Filename: ").append(reportName);
                        builder.append(System.lineSeparator()).append(System.lineSeparator());
                        builder.append("Reason: ").append(reasons);
                        builder.append(System.lineSeparator()).append(System.lineSeparator());
                        builder.append("Please contact Treasury Support to correct Customer's entitlements.");
                        String subject = "TFR - Swift (FIN) message to customer failed to transmit.";
                        System.out.println(subject);
                        System.out.println(builder);                        
					}
				}
				// FileUtils.moveFileToDirectory(file, new File("Cma/tfr/scheduler/Globalscape/done"), true);
			} catch (IOException e) {
				try {
					FileUtils.moveFileToDirectory(file, new File("Cma/tfr/scheduler/Globalscape/error"), true);
				} catch (IOException ex) {
					ex.printStackTrace(System.err);
				}
			}
		}
	}
}
