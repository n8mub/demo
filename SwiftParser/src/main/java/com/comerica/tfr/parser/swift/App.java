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

							System.out.println(ack);
							System.out.println("Reference: " + mt.getApplicationId());
							String reference = mt.getSwiftMessage().getUserBlock("S").getTagValue("REF");
							String reportName = Arrays.stream(reference.split("\\/")).limit(1).collect(Collectors.joining(""));
							System.out.println("report name: " + reportName);
							System.out.println("Service: " + sm.getBlock1().getServiceId());
							System.out.println("Seq num: " + mt.getSequenceNumber());
							System.out.println("Session num: " + mt.getSessionNumber());
							System.out.println("Ack: " + sm.isAck());
							System.out.println("Nack: " + sm.isNack());
							System.out.println("message: " + mt.message());

						} else if (up.isType(942)) {
							MT942 mt = new MT942(up);
							System.out.println("Reference: " + mt.getApplicationId());
							String reference = mt.getSwiftMessage().getUserBlock("S").getTagValue("REF");
							String reportName = Arrays.stream(reference.split("\\/")).limit(1).collect(Collectors.joining(""));
							System.out.println("reference name: " + reportName);
							System.out.println("Service: " + sm.getBlock1().getServiceId());
							System.out.println("Seq num: " + mt.getSequenceNumber());
							System.out.println("Session num: " + mt.getSessionNumber());
							System.out.println("Ack: " + sm.isAck());
							System.out.println("Nack: " + sm.isNack());
							System.out.println("message: " + mt.message());
						}
					}
				}
				// FileUtils.moveFileToDirectory(file, new File("Cma/tfr/scheduler/Globalscape/done"), true);
			} catch (IOException e) {
				try {
					FileUtils.moveFileToDirectory(file, new File("Cma/tfr/scheduler/Globalscape/error"), true);
				} catch (IOException ex) {
					ex.getMessage();
					ex.printStackTrace(System.err);
				}
			}
		}
	}
}
