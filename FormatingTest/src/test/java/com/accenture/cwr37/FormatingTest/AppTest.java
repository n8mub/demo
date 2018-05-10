package com.accenture.cwr37.FormatingTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	String newline = "\n";
	String ls = System.lineSeparator();

	/**
	 * Rigorous Test :-)
	 */
	@Test
	public void shouldAnswerWithTrue() {
		assertTrue(true);
	}

	@Test
	public void testFormat() {
		String input = "Hello" + newline
				+ "" + newline
				+ "World";
		String expected = "Hello"+ ls
				+ "" + ls
				+ "World"+ls;
		assertEquals(expected, App.format(input));
	}

}
