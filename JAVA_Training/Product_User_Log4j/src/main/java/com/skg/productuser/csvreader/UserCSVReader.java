package com.skg.productuser.csvreader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import java.nio.Buffer;
import java.text.ParseException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.skg.productuser.exception.FileNotSupportException;
import com.skg.productuser.exception.InvalidUserProductException;
import com.skg.productuser.model.User;

/**
 * UserCSVReader Class used to Read the content of each user from the given CSV
 * file
 * 
 * @author Khawja
 * @version 1.0
 */
public class UserCSVReader {
	/**
	 * Creating the Logger object called log that is used to get the logging
	 * information of UserCSVReader class
	 */
	final static Logger LOGGER_OBJ = Logger.getLogger(UserCSVReader.class);
	public static final String USERCS_FILENAME = "User.csv";
	public static final String SEPERATOR_COMMA = ",";

	/**
	 * getAllUser():: This is a method used to read each user data into a unique
	 * user instances then adding this instances to the ArrayList object .
	 * 
	 * @return returns the ArrayList that contains all users.
	 * @throws FileNotSupportException     :: Used to throw Exception which occur
	 *                                     during execution
	 * @throws InvalidUserProductException
	 */
	public ArrayList<User> getAllUser() throws FileNotSupportException, InvalidUserProductException {
		/**
		 * Creating the classLoader object through which we can read the resources.
		 */
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(USERCS_FILENAME).getFile());
		/**
		 * String line: String fileds[] array that contains user data after spliting.
		 */
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
		return user;
	}
}
