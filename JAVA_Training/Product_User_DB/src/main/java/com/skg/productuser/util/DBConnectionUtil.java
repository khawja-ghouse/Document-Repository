package com.skg.productuser.util;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.skg.productuser.exception.FileNotSupportException;
import com.skg.productuser.exception.GeneralSqlException;

public class DBConnectionUtil {

	public static final String PROPERTIS_NAME = "db.properties";
	public static final String DRIVER_CLASSNAME = "driverClassName";
	public static final String URL = "url";
	public static final String USER_NAME = "username";
	public static final String PASSWORD = "password";
	final static Logger LOGGER_OBJ = Logger.getLogger(DBConnectionUtil.class);
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	private static Connection dbConnection = null;

	static {
		ClassLoader classLoader = new ClassLoader() {
		};
		classLoader.getClass().getClassLoader();
		File file = new File(classLoader.getResource(PROPERTIS_NAME).getFile());
		Properties pr = new Properties();
		FileReader fin;
		try {
			fin = new FileReader(file);
			pr.load(fin);
		} catch (FileNotFoundException e) {
			try {
				throw new FileNotSupportException("issue in the file", e);
			} catch (FileNotSupportException e1) {
				e1.printStackTrace();
			}
		} catch (IOException e) {
			try {
				throw new FileNotSupportException("issue in the file", e);
			} catch (FileNotSupportException e1) {
				e1.printStackTrace();
			}
		}

		driver = pr.getProperty(DRIVER_CLASSNAME);
		url = pr.getProperty(URL);
		username = pr.getProperty(USER_NAME);
		password = pr.getProperty(PASSWORD);
	}

	public static Connection getConnection() throws FileNotSupportException, SQLException {
		if (dbConnection != null && !dbConnection.isClosed()) {
			return dbConnection;
		}
		try {
			Class.forName(driver);// this driver suld be available in the classpath
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		try {
			dbConnection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			throw new GeneralSqlException("issue in the connection", e);
		}
		LOGGER_OBJ.debug("CONNECTION::" + dbConnection);
		return dbConnection;
	}
}
