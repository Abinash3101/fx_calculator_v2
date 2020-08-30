package com.anz.fxcalculator.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.anz.fxcalculator.service.ConverterService;

public class ConverterServiceTest {
	
	ConverterService target = new ConverterService();
	
	@Test
	public void testDirectFeed() {
		String actual = target.processInputs("AUD 100.00 in USD");
		String expected = "AUD 100.00 = USD 83.71";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testUnityFeed() {
		String actual = target.processInputs("CNY 100.00 in CNY");
		String expected = "CNY 100.00 = CNY 100.00";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testInvertedFeed() {
		String actual = target.processInputs("DKK 100.00 in EUR");
		String expected = "DKK 100.00 = EUR 13.44";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testCCYFeed() {
		String actual = target.processInputs("NOK 100.00 in USD");
		String expected = "NOK 100.00 = USD 14.21";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testInvalidCCYFeed() {
		String actual = target.processInputs("KRW 1000.00 in FJD");
		String expected = "Unable to find rate for KRW/FJD";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testNoAmountFeed() {
		String actual = target.processInputs("AUD ahd in DKK");
		String expected = "Amount is not there in input";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testSmallCaseInput() {
		String actual = target.processInputs("dkk 505.67 in gbp");
		String expected = "DKK 505.67 = GBP 53.36";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testMixedCaseInput() {
		String actual = target.processInputs("JPY 6789.9886 in nzd");
		String expected = "JPY 6789.9886 = NZD 72.72";
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testDecimalFormat() {
		String actual = target.processInputs("NOK 6789.9886 in JPY");
		String expected = "NOK 6789.9886 = JPY 115746";
		Assertions.assertEquals(expected, actual);
	}
}
