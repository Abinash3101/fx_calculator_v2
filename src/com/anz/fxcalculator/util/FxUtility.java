package com.anz.fxcalculator.util;

import static org.apache.commons.lang3.StringUtils.isBlank;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

import com.anz.fxcalculator.exception.InvalidInputException;

public final class FxUtility {

    public static boolean isValidCurrencyTerm(final String value) {
        return !StringUtils.isEmpty(value) && ConversionMatrixUtility.currencyList.stream().anyMatch(value::equalsIgnoreCase);
    }

    public static BigDecimal captureAmount(final String input) {
		final char[] chars = input.toCharArray();
		final StringBuilder sb = new StringBuilder();
		for (char c : chars) {
			if (Character.isDigit(c) || Character.valueOf(c).equals('.')) {
				sb.append(c);
			}
		}
		if (isBlank(sb)) {
			throw new InvalidInputException("Amount is not there in input");
		}
		return new BigDecimal(String.valueOf(sb));
    }
    
}
