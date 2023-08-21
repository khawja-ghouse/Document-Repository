package com.skg.userproduct.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.skg.userproduct.exception.FileNotSupportException;
import com.skg.userproduct.exception.GeneralSqlException;
import com.skg.userproduct.exception.InvalidUserProductException;

/**
 * DBConnevtionUtil is a class use to get the connection to the MYSQL Database.
 * It is the Singleton class which maintains the same connect for complete
 * project.
 * 
 * @author khawja
 * @version 1.0
 */
public class DBConnectionUtil {

	public static final String DB_PROPERTIS_NAME = "db.properties";
	public static final String DRIVER_CLASSNAME = "driverClassName";
	public static final String URL = "url";
	public static final String USER_NAME = "username";
	public static final String PASSWORD = "password";

	final static Logger LOGGER_OBJ = Logger.getLogger(DBConnectionUtil.class);
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	static Connection dbCon = null;

	/**
	 * private DBConnevtionUtil() :: Private constructor used to avoid creating
	 * Instances.
	 */
	private DBConnectionUtil() {

	}

	/**
	 * getconnection() :: Is the method used to get the connection to the MYSQL
	 * DB
	 * 
	 * @return returns the connection object
	 * @throws GeneralSqlException
	 * @throws InvalidUserProductException
	 * @throws FileNotSupportException
	 */
	public static Connection getconnection()
			throws GeneralSqlException, InvalidUserProductException, FileNotSupportException {

		/**
		 * Creating the classLoader object through which we can read the
		 * resources.
		 */
		ClassLoader classLoader = new ClassLoader() {
		};
		classLoader.getClass().getClassLoader();
		File file = new File(classLoader.getResource(DB_PROPERTIS_NAME).getFile());
		Properties pr = new Properties();
		FileReader fin;
		try {
			fin = new FileReader(file);
			pr.load(fin);
		} catch (FileNotFoundException e) {
			throw new FileNotSupportException("issue in the file", e);
		} catch (IOException e) {

			throw new FileNotSupportException("issue in the file", e);
		}

		driver = pr.getProperty(DRIVER_CLASSNAME);
		url = pr.getProperty(URL);
		username = pr.getProperty(USER_NAME);
		password = pr.getProperty(PASSWORD);

		try {
			if (dbCon == null) {
				// Class.forName(driver);
				dbCon = DriverManager.getConnection(url, username, password);
			}
		} catch (SQLException e) {
			throw new GeneralSqlException("Issue in connection", e);
		}
		return dbCon;
	}
}
