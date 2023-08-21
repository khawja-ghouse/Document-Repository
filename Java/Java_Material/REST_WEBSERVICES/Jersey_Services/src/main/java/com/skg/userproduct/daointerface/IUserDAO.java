package com.skg.userproduct.daointerface;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.skg.userproduct.exception.FileNotSupportException;
import com.skg.userproduct.exception.InvalidUserProductException;
import com.skg.userproduct.model.User;

/**
 * IProductDAO:: IProductDAO is the implementation for abstract methos like
 * exportUserData() => Export the User data to the Database or CSV file.
 * importUserData() => get the User list from Database or CSV file.
 * 
 * @author Khawja
 * @version 1.0
 */
public interface IUserDAO {

	List<User> exportUserData() throws FileNotSupportException, InvalidUserProductException, SQLException, IOException;

	boolean importUserData() throws SQLException, InvalidUserProductException, FileNotSupportException;
}
