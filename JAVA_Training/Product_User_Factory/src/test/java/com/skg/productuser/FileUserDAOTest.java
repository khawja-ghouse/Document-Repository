package com.skg.productuser;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.skg.userproduct.daointerface.IUserDAO;
import com.skg.userproduct.exception.FileNotSupportException;
import com.skg.userproduct.exception.InvalidUserProductException;
import com.skg.userproduct.factory.DAOFactory;
import com.skg.userproduct.model.User;

public class FileUserDAOTest {

	final static Logger LOGGER_OBJ = LoggerFactory.getLogger(FileUserDAOTest.class);
	private static final String USERCS_FILENAME = "User.csv";
	private static final String SEPERATOR_COMMA = ",";
	ClassLoader classLoader = getClass().getClassLoader();
	DAOFactory factoryObj = DAOFactory.getInstance();
	IUserDAO fuObj = factoryObj.getUserDAOInstance();

	@Test
	public void ExportUserDataTest() throws InvalidUserProductException, SQLException, IOException {
		File file = new File(classLoader.getResource(USERCS_FILENAME).getFile());
		String line, fileds[];
		boolean skipline = true;
		ArrayList<User> user = new ArrayList<User>();
		try (FileReader fin = new FileReader(file); BufferedReader bin = new BufferedReader(fin)) {
			while ((line = bin.readLine()) != null) {
				if (skipline) {
					skipline = false;
					continue;
				}
				User userobj = new User();
				fileds = line.split(SEPERATOR_COMMA);
				userobj.setUserId(fileds[0]);
				userobj.setUserName(fileds[1]);
				userobj.setEmail(fileds[2]);
				userobj.setPhoneNumber(fileds[3]);
				userobj.setCity(fileds[4]);
				user.add(userobj);
			}
			LOGGER_OBJ.debug("User data" + user);
		} catch (NumberFormatException e) {
			throw new InvalidUserProductException("Invalid format exception", e);
		} catch (NullPointerException e) {
			throw new InvalidUserProductException("there is a null pointing exception", e);
		} catch (IOException e) {
			LOGGER_OBJ.error("Issue in the file Provided");
			throw new FileNotSupportException("Issue in the file Provided", e);
		}
		assertEquals(true, fuObj.exportUserData());
		assertEquals(user, fuObj.importUserData());
	}

}
