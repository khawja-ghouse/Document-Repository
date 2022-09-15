package com.skg.productuser;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import com.skg.productuser.dao.ProductUserDAO;
import com.skg.productuser.exception.FileNotSupportException;
import com.skg.productuser.exception.InvalidUserProductException;
import com.skg.productuser.model.User;

public class UserCSVImportToDBTest {

	public static final String USERCS_FILENAME = "User.csv";
	public static final String SEPERATOR_COMMA = ",";

	@Test
	public void getAllUsertest() throws FileNotSupportException, InvalidUserProductException, SQLException {

		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(USERCS_FILENAME).getFile());
		ProductUserDAO pudao = new ProductUserDAO();
		String line, fileds[];
		boolean skipline = true;
		ArrayList<User> userList = new ArrayList<User>();
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
				userList.add(userobj);
			}
		} catch (NumberFormatException e) {
			throw new InvalidUserProductException("Invalid format exception", e);
		} catch (NullPointerException e) {
			throw new InvalidUserProductException("there is a null pointing exception", e);
		} catch (IOException e) {

			throw new FileNotSupportException("Issue in the file Provided", e);
		}
		assertEquals(userList, pudao.getAllUsers());
	}

}
