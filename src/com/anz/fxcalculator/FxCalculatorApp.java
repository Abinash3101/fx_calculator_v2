package com.anz.fxcalculator;

import java.util.Scanner;
import java.util.logging.Logger;

import com.anz.fxcalculator.service.ConverterService;

public class FxCalculatorApp {

	private static final Logger LOGGER = Logger.getLogger(FxCalculatorApp.class.getName());

	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in)) {
			LOGGER.info("Enter conversion input(pattern: <ccy1> <amount1> in <ccy2> e.g. AUD 100.00 in USD): ");
			final String input = scanner.nextLine();
			ConverterService service = new ConverterService();
			String output = service.processInputs(input);
			LOGGER.info(output);
		}
	}

}
