package com.accenture.cwr37.FormatingTest;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		LinkedList<File> files = (LinkedList<File>) FileUtils.listFiles(new File("src/main/resources"), new String[] {"txt","ftl"}, false);
		List<String> filetexts = new LinkedList<String>();
		for(File file : files) {
			try {
				List<String> lines = FileUtils.readLines(file, "UTF-8");
				String text = FileUtils.readFileToString(file, "UTF-8");
				String newtext = StringUtils.replace(text, "\n", System.lineSeparator());
				String newtext1 = StringUtils.replace(newtext, "\n", System.lineSeparator());
				while(newtext1.contains("\r\r")) {
					newtext1 = StringUtils.replace(newtext1, "\r\r", "\r");
				}
				System.out.println(lines.size());
				filetexts.add(text);
			} catch (IOException e) {
				e.printStackTrace(System.err);
			}
		}
		List<String> formatedtext = new LinkedList<String>();
		for(String text : filetexts) {
			String formated = format(text);
			formatedtext.add(formated);
		}
	}
	
	private static String format(String text) {
		StringBuilder formatedtext = new StringBuilder();
		String[] lines = StringUtils.split(text, "\n");
		for(String line : lines) {
			formatedtext.append(line.trim()).append(System.lineSeparator());
		}
		return formatedtext.toString();
	}
}
