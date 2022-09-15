package com.skg.productuser.exception;

import java.io.IOException;

/**
 * FileNotSupportException is a custom class used to Provid IOExceptions
 * 
 * @author Khawja
 * @version 1.0
 */
public class FileNotSupportException extends IOException {

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
