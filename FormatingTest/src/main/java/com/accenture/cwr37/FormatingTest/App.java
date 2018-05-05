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
		LinkedList<File> files = (LinkedList<File>) FileUtils.listFiles(new File("src/main/resources"), new String[] {"txt"}, false);
		File file = files.getFirst();
		try {
			List<String> lines = FileUtils.readLines(file, "UTF-8");
			String text = FileUtils.readFileToString(file, "UTF-8");
			String newtext = StringUtils.replace(text, "\n", System.lineSeparator());
			String newtext1 = StringUtils.replace(newtext, "\n", System.lineSeparator());
			String newtext2 = StringUtils.replace(newtext1, "\r\r", "\r");
			System.out.println(lines.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
