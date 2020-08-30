package com.anz.fxcalculator.util;

import java.util.HashMap;
import java.util.Map;

public class DecimalFormatValuesUtility {
	public static final  Map<String, Integer> decimalMap = new HashMap<String, Integer>();
	
	static {
		decimalMap.put("CAD", 2);
		decimalMap.put("CNY", 2);
		decimalMap.put("CZK", 2);
		decimalMap.put("DKK", 2);
		decimalMap.put("EUR", 2);
		decimalMap.put("GBP", 2);
		decimalMap.put("JPY", 0);
		decimalMap.put("NOK", 2);
		decimalMap.put("NZD", 2);
		decimalMap.put("USD", 2);
		decimalMap.put("AUD", 2);
	}

}
