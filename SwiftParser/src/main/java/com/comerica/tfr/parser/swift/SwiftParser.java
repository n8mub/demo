package com.comerica.tfr.parser.swift;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import com.prowidesoftware.swift.model.SwiftMessage;
import com.prowidesoftware.swift.model.mt.mt9xx.MT940;
import com.prowidesoftware.swift.model.mt.mt9xx.MT942;

public class SwiftParser {
	public void processAck() {
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
						
						if(sm.isAck()) {
							/* code  for positive acknowledgement */
						}else if(sm.isNack()) {
							/* code for negative acknowledgment */
						}

						System.out.println("Message Type: " + up.getType());

						if (up.isType(940)) {

							MT940 mt = new MT940(up);

							System.out.println("Reference: " + mt.getApplicationId());
							System.out.println("Service: " + sm.getBlock1().getServiceId());
							System.out.println("Ack: " + sm.isAck());
							System.out.println("Nack: " + sm.isNack());
							System.out.println("message: " + mt.message());

						} else if (up.isType(942)) {
							MT942 mt = new MT942(up);
							System.out.println("Reference: " + mt.getApplicationId());
							System.out.println("Service: " + sm.getBlock1().getServiceId());
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
					// log error
					ex.printStackTrace(System.err);
				}
			}
		}
	}

}
