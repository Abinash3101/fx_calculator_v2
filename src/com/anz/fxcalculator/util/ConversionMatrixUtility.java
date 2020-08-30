package com.anz.fxcalculator.util;

import java.util.Arrays;
import java.util.List;

public final class ConversionMatrixUtility {
	public static final List<String> currencyList = Arrays.asList("AUD", "CAD", "CNY", "CZK", "DKK", "EUR", "GBP", "JPY", "NOK", "NZD","USD");
	
	private static final String[][] crossViaMatrix = {
			{ "", "AUD", "CAD", "CNY", "CZK", "DKK", "EUR", "GBP", "JPY", "NOK", "NZD", "USD" },
			{ "AUD", "1:1", "USD", "USD", "USD", "USD", "USD", "USD", "USD", "USD", "USD", "D" },
			{ "CAD", "USD", "1:1", "USD", "USD", "USD", "USD", "USD", "USD", "USD", "USD", "D" },
			{ "CNY", "USD", "USD", "1:1", "USD", "USD", "USD", "USD", "USD", "USD", "USD", "Inv" },
			{ "CZK", "USD", "USD", "USD", "1:1", "EUR", "Inv", "USD", "USD", "EUR", "USD", "EUR" },
			{ "DKK", "USD", "USD", "USD", "EUR", "1:1", "Inv", "USD", "USD", "EUR", "USD", "EUR" },
			{ "EUR", "USD", "USD", "USD", "D", "D", "1:1", "USD", "USD", "D", "USD", "D" },
			{ "GBP", "USD", "USD", "USD", "USD", "USD", "USD", "1:1", "USD", "USD", "USD", "D" },
			{ "JPY", "USD", "USD", "USD", "USD", "USD", "USD", "USD", "1:1", "USD", "USD", "Inv" },
			{ "NOK", "USD", "USD", "USD", "EUR", "EUR", "Inv", "USD", "USD", "1:1", "USD", "EUR" },
			{ "NZD", "USD", "USD", "USD", "USD", "USD", "USD", "USD", "USD", "USD", "1:1", "D" },
			{ "USD", "Inv", "Inv", "D", "EUR", "EUR", "Inv", "Inv", "D", "EUR", "Inv", "1:1" }
	};
	
	public static final String getConversionFeed(final String baseCurrency, final String termCurrency) {
		return crossViaMatrix[currencyList.indexOf(baseCurrency) + 1][currencyList.indexOf(termCurrency) + 1];
	}

}
