package com.skg.userproduct.daoimpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.opencsv.CSVWriter;
import com.skg.userproduct.daointerface.IUserDAO;
import com.skg.userproduct.exception.FileNotSupportException;
import com.skg.userproduct.exception.GeneralSqlException;
import com.skg.userproduct.exception.InvalidUserProductException;
import com.skg.userproduct.model.User;

/**
 * FileUserDAO :: FileUserDAO class is used to provide the implementation for
 * the exporting user data to the CSV file and importing the Userdata from the
 * same and return it as list.
 * 
 * @author Khawja
 * @version 1.0
 */
public class FileUserDAO implements IUserDAO {
	/**
	 * Creating the Logger object called log that is used to get the logging
	 * information of FileProductDAO class
	 */

	final static Logger LOGGER_OBJ = Logger.getLogger(FileUserDAO.class);
	private static final String EXPORTED_USER_LIST = "UserNew.csv";
	private static final String USERCS_FILENAME = "User.csv";
	private static final String SEPERATOR_COMMA = ",";

	/**
	 * importUserData():: Method used to insert the UserCSV file data to the another
	 * CSV file . The user data such as name, id , email,phone number into the one
	 * CSV file.
	 * 
	 * @throws InvalidUserProductException
	 * @throws FileNotSupportException
	 * @throws GeneralSqlException
	 * @return returns true if inserted successfully and false if there is some
	 *         exception.
	 */

	@Override
	public boolean importUserData() throws FileNotSupportException, InvalidUserProductException, SQLException {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(USERCS_FILENAME).getFile());
		String line, fileds[];
		try (FileWriter fout = new FileWriter(EXPORTED_USER_LIST);
				CSVWriter writer = new CSVWriter(fout, ',', CSVWriter.NO_QUOTE_CHARACTER,
						CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
				FileReader fin = new FileReader(file);
				BufferedReader bin = new BufferedReader(fin)) {
			while ((line = bin.readLine()) != null) {
				fileds = line.split(SEPERATOR_COMMA);
				writer.writeNext(fileds);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		LOGGER_OBJ.debug("done with exporting user data to CSV");
		return true;
	}

	/**
	 * exportUserData():: Method used to retrieve the userdata from the userCSV and
	 * then store in the List.
	 * 
	 * @return ::returns the list of all product containing in CSV file.
	 * @throws IOException
	 */
	@Override
	public List<User> exportUserData() throws InvalidUserProductException, IOException {
		/**
		 * Creating the classLoader object through which we can read the resources.
		 */
		ClassLoader classLoader = getClass().getClassLoader();
		String file = classLoader.getResource(USERCS_FILENAME).getFile();
		/**
		 * String line: String fields[] array that contains user data after spiting.
		 */
		ArrayList<User> user = new ArrayList<User>();
		Files.lines(new File(file).toPath()).skip(1).map(s2 -> s2.trim()).forEach(linen -> {
			User userobj = new User();
			String[] filed = linen.split(SEPERATOR_COMMA);
			userobj.setUserId(filed[0]);
			userobj.setUserName(filed[1]);
			userobj.setEmail(filed[2]);
			userobj.setPhoneNumber(filed[3]);
			userobj.setCity(filed[4]);
			user.add(userobj);
		});
		return user;
	}
}
