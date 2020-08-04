/**
 * Class ImpossibleMoveException extends RuntimeException class 
 * thrown when a move is not possible
 * 
 * @author laghdafk
 * 
 */
package com.rover.exception;


public class ImpossibleMoveException extends RuntimeException {

	private static final long serialVersionUID = 1L;


	public ImpossibleMoveException() {
		super("Impossible move!");
	}

	/**
	 * @param message
	 */
	public ImpossibleMoveException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ImpossibleMoveException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ImpossibleMoveException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ImpossibleMoveException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
