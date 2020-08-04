package com.rover.exception;

public class UnknownMoveException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnknownMoveException() {
		super("Unknown move!");
	}

	public UnknownMoveException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UnknownMoveException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public UnknownMoveException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UnknownMoveException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
