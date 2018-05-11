package com.accenture.cwr37.FormatingTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	String newline = StringUtils.LF;
	String ls = StringUtils.CR + StringUtils.LF;
	
	/**
	 * Rigorous Test :-)
	 */
	@Test
	public void shouldAnswerWithTrue() {
		assertTrue(true);
	}
	
	@Test
	public void testReportFormat() {
		 
		LocalDateTime dateTime = LocalDateTime.now();
        String date = dateTime.format(DateTimeFormatter.ofPattern("MM/dd/yy"));
        String time = dateTime.format(DateTimeFormatter.ofPattern("h:mma")).toLowerCase();
        String input = "Date: "+date+"                     Account List Report"+newline +
                "Time: "+time+"                      Application Development Services 1"+newline +
                "Page: 1                                  ADS1_CNG"+newline +
                ""+newline +
                "Information Reporting Accounts"+newline +
                "------------------------------"+newline +
                ""+newline +
                "Account Number                                     ABA/SWIFT"+newline +
                "-------------------------------------------------- ---------       "+newline +
                "1012514143                                         072000096"+newline +
                "Customer Reference: Account Transfer"+newline +
                "Services: ACH"+newline +
                ""+newline +
                "1029189956                                         072000096"+newline +
                "Customer Reference: Account Transfer"+newline +
                "Services: ACH"+newline;
        String generatedReport = App.format(input);
 
        String expectedReport = "Date: "+date+"                     Account List Report"+ls +
                "Time: "+time+"                      Application Development Services 1"+ls +
                "Page: 1                                  ADS1_CNG"+ls +
                ""+ls +
                "Information Reporting Accounts"+ls +
                "------------------------------"+ls +
                ""+ls +
                "Account Number                                     ABA/SWIFT"+ls +
                "-------------------------------------------------- ---------       "+ls +
                "1012514143                                         072000096"+ls +
                "Customer Reference: Account Transfer"+ls +
                "Services: ACH"+ls +
                ""+ls +
                "1029189956                                         072000096"+ls +
                "Customer Reference: Account Transfer"+ls +
                "Services: ACH"+ls;
 
        assertEquals(expectedReport,generatedReport);
	}
	
	@Test
	public void testFormat() {
		String input = "Hello" + newline
				+ "" + newline
				+ "World";
		String expected = "Hello"+ ls
				+ "" + ls
				+ "World";
		assertEquals(expected, App.format(input));
	}
}
