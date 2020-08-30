package com.anz.fxcalculator.exception;

public class InvalidInputException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4006531827011724953L;

	public InvalidInputException(String message) {
        super(message);
    }
}
