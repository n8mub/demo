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
	static String ls = StringUtils.CR + StringUtils.LF;
	static String repeat = StringUtils.CR + StringUtils.CR;
	public static void main(String[] args) {
		LinkedList<File> files = (LinkedList<File>) FileUtils.listFiles(new File("src/main/resources"), new String[] {"log"}, false);
		List<String> filetexts = new LinkedList<String>();
		List<List<String>> linelist = new LinkedList<List<String>>();
		for(File file : files) {
			try {
				List<String> lines = FileUtils.readLines(file, "UTF-8");
				String text = FileUtils.readFileToString(file, "UTF-8");
				String newtext = StringUtils.replace(text, StringUtils.LF, System.lineSeparator());
				String newtext1 = StringUtils.replace(newtext, StringUtils.LF, System.lineSeparator());
				while(newtext1.contains(repeat)) {
					newtext1 = StringUtils.replace(newtext1, repeat, StringUtils.CR);
				}
				System.out.println(lines.size());
				filetexts.add(text);
				linelist.add(lines);
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
	
	public static String format(String text) {
		String newtext = StringUtils.replace(text, StringUtils.LF, ls);
		while(newtext.contains(repeat)) {
			newtext = StringUtils.replace(newtext, repeat, StringUtils.CR);
		}
		return newtext;
//		StringBuilder formatedtext = new StringBuilder();
//		String[] lines = StringUtils.split(text, StringUtils.LF);
//		for(String line : lines) {
//			formatedtext.append(line.trim()).append(StringUtils.CR + StringUtils.LF);
//		}
//		return formatedtext.toString();
	}
}
