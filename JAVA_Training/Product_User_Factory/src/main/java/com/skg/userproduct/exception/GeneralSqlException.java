package com.skg.userproduct.exception;

import java.sql.SQLException;
/**
 * GeneralSqlException :: GeneralSqlException class used to throw the custom exception of SQL type.
 * @author Khawja
 * @version 1.0
 */
public class GeneralSqlException extends SQLException{



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GeneralSqlException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GeneralSqlException(String reason, String sqlState, int vendorCode, Throwable cause) {
		super(reason, sqlState, vendorCode, cause);
		// TODO Auto-generated constructor stub
	}

	public GeneralSqlException(String reason, String SQLState, int vendorCode) {
		super(reason, SQLState, vendorCode);
		// TODO Auto-generated constructor stub
	}

	public GeneralSqlException(String reason, String sqlState, Throwable cause) {
		super(reason, sqlState, cause);
		// TODO Auto-generated constructor stub
	}

	public GeneralSqlException(String reason, String SQLState) {
		super(reason, SQLState);
		// TODO Auto-generated constructor stub
	}

	public GeneralSqlException(String reason, Throwable cause) {
		super(reason, cause);
		// TODO Auto-generated constructor stub
	}

	public GeneralSqlException(String reason) {
		super(reason);
		// TODO Auto-generated constructor stub
	}

	public GeneralSqlException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
}
