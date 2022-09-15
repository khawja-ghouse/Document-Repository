package com.skg.userproduct.exception;

/**
 * InvalidUserProductException :: InvalidUserProductException class used to
 * throw the General custom exception .
 * 
 * @author khawja
 * @version 1.0
 */
public class InvalidUserProductException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidUserProductException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidUserProductException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public InvalidUserProductException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidUserProductException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidUserProductException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
