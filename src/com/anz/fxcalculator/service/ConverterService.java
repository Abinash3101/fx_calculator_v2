package com.anz.fxcalculator.service;

import static com.anz.fxcalculator.util.Constants.DIRECT_FEED;
import static com.anz.fxcalculator.util.Constants.INVERTED;
import static com.anz.fxcalculator.util.Constants.UNITY;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.anz.fxcalculator.exception.InvalidInputException;
import com.anz.fxcalculator.util.ConversionMatrixUtility;
import com.anz.fxcalculator.util.ConversionRatesUtility;
import com.anz.fxcalculator.util.DecimalFormatValuesUtility;
import com.anz.fxcalculator.util.FxUtility;

public class ConverterService {
	
	private BigDecimal convert(final String base, final String term, final BigDecimal baseAmount) {
		final String conversionPattern = ConversionMatrixUtility.getConversionFeed(base, term);
		BigDecimal result = new BigDecimal(0);
		switch (conversionPattern) {
		case UNITY:
			result = baseAmount;
			break;
		case DIRECT_FEED:
			result = baseAmount.multiply(ConversionRatesUtility.ratesMap.get(base + term)).
            setScale(DecimalFormatValuesUtility.decimalMap.get(term), BigDecimal.ROUND_HALF_EVEN);
			break;
		case INVERTED:
			result = baseAmount.multiply(BigDecimal.ONE.divide(ConversionRatesUtility.ratesMap.get(term + base), 4, RoundingMode.HALF_EVEN))
            .setScale(DecimalFormatValuesUtility.decimalMap.get(term), BigDecimal.ROUND_HALF_EVEN);
			break;
		default: //CCY
			BigDecimal crossOverValue = convert(base, conversionPattern, baseAmount);
            result = convert(conversionPattern,term,crossOverValue);
			break;
		}
        return result;
	}
	
	public String processInputs(final String input) {
		final String base;
		final String term;
		StringJoiner outputJoiner = new StringJoiner(" ");
		BigDecimal baseAmount = BigDecimal.valueOf(0);
		final List<String> inputTokens = Collections.list(new StringTokenizer(StringUtils.trim(input), " ")).stream()
				.map(token -> (String) token).collect(Collectors.toList());
		base = inputTokens.get(0);
		term = inputTokens.get(inputTokens.size() - 1);
		try {
			baseAmount = FxUtility.captureAmount(input);
		} catch (InvalidInputException e) {
			return e.getMessage();
		} 
		if (FxUtility.isValidCurrencyTerm(base) && FxUtility.isValidCurrencyTerm(term)) {
			ConverterService service = new ConverterService();
			BigDecimal result = service.convert(base.toUpperCase(), term.toUpperCase(), baseAmount);
			return outputJoiner.add(base.toUpperCase()).add(baseAmount.toString()).add("=").
					add(term.toUpperCase()).add(result.toString()).toString();
		} else {
			return "Unable to find rate for" + " " + base + "/" + term;
		}
	}
}
