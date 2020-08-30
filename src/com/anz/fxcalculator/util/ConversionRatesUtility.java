package com.anz.fxcalculator.util;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public final class ConversionRatesUtility {
	public static final Map<String, BigDecimal> ratesMap = new HashMap<String, BigDecimal>();
	
	static {
		ratesMap.put("AUDUSD", BigDecimal.valueOf(0.8371));
		ratesMap.put("CADUSD", BigDecimal.valueOf(0.8711));
		ratesMap.put("USDCNY", BigDecimal.valueOf(6.1715));
		ratesMap.put("EURUSD", BigDecimal.valueOf(1.2315));
		ratesMap.put("GBPUSD", BigDecimal.valueOf(1.5683));
		ratesMap.put("NZDUSD", BigDecimal.valueOf(0.7750));
		ratesMap.put("USDJPY", BigDecimal.valueOf(119.95));
		ratesMap.put("EURCZK", BigDecimal.valueOf(27.6028));
		ratesMap.put("EURDKK", BigDecimal.valueOf(7.4405));
		ratesMap.put("EURNOK", BigDecimal.valueOf(8.6651));
	}
	

}
