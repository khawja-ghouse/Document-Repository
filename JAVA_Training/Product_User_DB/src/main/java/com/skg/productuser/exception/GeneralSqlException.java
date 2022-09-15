package com.skg.productuser.exception;

import java.sql.SQLException;

public class GeneralSqlException extends SQLException{

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
