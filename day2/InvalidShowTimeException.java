package com.impact.day2;

public class InvalidShowTimeException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidShowTimeException(String errorMessage) {
        super(errorMessage);
    }
}
