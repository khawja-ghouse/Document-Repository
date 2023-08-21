package com.skg.userproduct.exception;

import java.io.IOException;

/**
 * FileNotSupportException is a custom class used to Provid IOExceptions
 * 
 * @author Khawja
 * @version 1.0
 */
public class FileNotSupportException extends IOException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FileNotSupportException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FileNotSupportException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public FileNotSupportException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public FileNotSupportException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
