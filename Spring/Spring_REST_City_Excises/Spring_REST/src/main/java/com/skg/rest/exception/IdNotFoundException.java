package com.skg.rest.exception;

public class IdNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IdNotFoundException(String msg) {
		super(msg);
	}

	public IdNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IdNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public IdNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public IdNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
