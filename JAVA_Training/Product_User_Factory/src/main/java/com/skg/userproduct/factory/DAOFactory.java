package com.skg.userproduct.factory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.skg.userproduct.daoimpl.DBProductDAO;
import com.skg.userproduct.daoimpl.DBUserDAO;
import com.skg.userproduct.daoimpl.FileProductDAO;
import com.skg.userproduct.daoimpl.FileUserDAO;
import com.skg.userproduct.daointerface.IProductDAO;
import com.skg.userproduct.daointerface.IUserDAO;

/**
 * DAOFactor is Singleton class. This class exists the methods used to return
 * either DBproductDAO,FileProductDAO or DBuserDAO , FileUserDAO instances which
 * is been implemented by the two DAO interfaces IProductDAO and IUserDAO.
 * 
 * @author Khawja
 * @version 1.0
 */
public class DAOFactory {
	/**
	 * private DAOFactory() :: Private constructor used to avoid creating
	 * Instances.
	 */
	private DAOFactory() {
	}

	/**
	 * Properties class to read the Application properties.
	 */
	static Properties pr = new Properties();
	/**
	 * PROPERTIS_NAME constant having application.properties
	 */
	private static final String APPLICATION_PROPERTY_FILE_NAME = "application.properties";
	/**
	 * FILE constant having file string
	 */
	private static final String FILE = "file";
	/**
	 * DATABASE constant having database string
	 */
	private static final String DATABASE = "database";

	public static final String RESOURCE_TYPE = "resourceType";
	/**
	 * static block used to read the application properties.
	 */
	static {
		ClassLoader classLoader = new ClassLoader() {
		};
		classLoader.getClass().getClassLoader();
		File file = new File(classLoader.getResource(APPLICATION_PROPERTY_FILE_NAME).getFile());

		FileReader fin;
		try {
			fin = new FileReader(file);
			pr.load(fin);
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}

	public static DAOFactory factoryobj = null;

	/**
	 * getInstance() the method used to return the same DAOfactory instance
	 * every time its called.
	 * 
	 * @return returns DAOfactory instance.
	 */
	public static DAOFactory getInstance() {
		if (factoryobj == null) {
			factoryobj = new DAOFactory();
		}
		return factoryobj;
	}

	/**
	 * getProductDAOInstance() :: Method used to return FileProductDAO Instance
	 * or DBProductDAO instance based on the Application properties
	 * 
	 * @return returns FileProductDAO and DBProductDAO.
	 */
	public IProductDAO getProductDAOInstance() {
		if (FILE.equals(pr.getProperty(RESOURCE_TYPE))) {
			return new FileProductDAO();
		}
		if (DATABASE.equals(pr.getProperty(RESOURCE_TYPE))) {
			return new DBProductDAO();
		}
		return null;
	}

	/**
	 * getProductDAOInstance() :: Method used to return FileUserDAO Instance or
	 * DBuserDAO instance based on the Application properties
	 * 
	 * @return FileUserDAO and DBuserDAO
	 */
	public IUserDAO getUserDAOInstance() {
		if (FILE.equals(pr.getProperty(RESOURCE_TYPE))) {
			return new FileUserDAO();
		}
		if (DATABASE.equals(pr.getProperty(RESOURCE_TYPE))) {
			return new DBUserDAO();
		}
		return new FileUserDAO();
	}
}
