package com.impact.day2;

public class SeatsNotAvailableException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SeatsNotAvailableException(String errorMessage) {
        super(errorMessage);
	}

}
