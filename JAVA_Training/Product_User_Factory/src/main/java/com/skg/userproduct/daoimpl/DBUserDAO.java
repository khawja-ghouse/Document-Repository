package com.skg.userproduct.daoimpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.skg.userproduct.daointerface.IUserDAO;
import com.skg.userproduct.exception.FileNotSupportException;
import com.skg.userproduct.exception.GeneralSqlException;
import com.skg.userproduct.exception.InvalidUserProductException;
import com.skg.userproduct.model.User;
import com.skg.userproduct.util.DBConnectionUtil;

import org.apache.log4j.Logger;

/**
 * DBUserDAO :: DBUserDAO class is used to provide the implementation for the
 * exporting User data to the Database and importing the same data and return it
 * as list of users.
 * 
 * @author Khawja
 * @version 1.0
 */
public class DBUserDAO implements IUserDAO {

	/**
	 * Creating the Logger object called log that is used to get the logging
	 * information of UserCSVReader class
	 */
	final static Logger LOGGER_OBJ = Logger.getLogger(DBUserDAO.class);
	private static final String SEPERATOR_COMMA = ",";
	private static final String USERCS_FILENAME = "User.csv";
	private static final String USEER_QUERY = "INSERT INTO USER VALUES(?,?,?,?,?)";
	private static final String USEER_selectQUERY = "SELECT * FROM USER";
	/**
	 * Creating the classLoader object through which we can read the resources.
	 */
	ClassLoader classLoader = getClass().getClassLoader();

	/**
	 * exportUserData():: Method used to insert the userCSV file data to the
	 * database. The User data such as name, id email, mobile number into the
	 * User table;
	 * 
	 * @throws InvalidUserProductException
	 * @throws FileNotSupportException
	 * @throws GeneralSqlException
	 * @return returns true if inserted successfully and false if there is some
	 *         exception.
	 */
	@Override
	public boolean importUserData() throws SQLException, InvalidUserProductException, FileNotSupportException {

		File file = new File(classLoader.getResource(USERCS_FILENAME).getFile());
		/**
		 * String line: String fields[] array that contains user data after
		 * spiting.
		 */
		String line, fileds[];
		boolean skipline = true;
		try {
			try (FileReader fin = new FileReader(file); BufferedReader bin = new BufferedReader(fin)) {
				while ((line = bin.readLine()) != null)
					try {
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
						LOGGER_OBJ.debug(userobj);
						addUsers(userobj);
					} catch (Exception e) {
						throw new InvalidUserProductException("Exception in the Useror product", e);
					}
			} catch (NumberFormatException e) {
				throw new InvalidUserProductException("Invalid format exception", e);
			} catch (NullPointerException e) {
				throw new InvalidUserProductException("there is a null pointing exception", e);
			} catch (IOException e) {
				LOGGER_OBJ.error("Issue in the file Provided");
				throw new FileNotSupportException("Issue in the file Provided", e);
			}
		} catch (Exception e) {
			throw new InvalidUserProductException("Error in exporting data to DB", e);
		}
		return true;
	}

	/**
	 * addUsers():: The method used to add the user to the database table
	 * specified.
	 * 
	 * @param userObj
	 *            the user that should be added to the database.
	 * @throws FileNotSupportException
	 * @throws InvalidUserProductException
	 * @throws SQLException
	 */
	public static void addUsers(User userObj)
			throws FileNotSupportException, InvalidUserProductException, SQLException {
		Connection con = DBConnectionUtil.getconnection();
		PreparedStatement prstmt = null;
		try {

			System.out.println(con);
			System.out.println(userObj);
			prstmt = con.prepareStatement(USEER_QUERY);
			prstmt.setString(1, userObj.getUserId());
			prstmt.setString(2, userObj.getUserName());
			prstmt.setString(3, userObj.getEmail());
			prstmt.setString(4, userObj.getPhoneNumber());
			prstmt.setString(5, userObj.getCity());
			prstmt.execute();
		} catch (SQLException e) {
			throw new GeneralSqlException("Issue in the connection", e);
		} finally {
			if (prstmt != null) {
				try {
					prstmt.close();
				} catch (SQLException e) {
					throw new GeneralSqlException("Issue in the connection", e);
				}

			} else if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					throw new GeneralSqlException("Issue in the connection", e);
				}

			}
		}
	}

	/**
	 * importUserData():: Method used to retrieve the User data from the
	 * Database and then store in the List.
	 * 
	 * @return ::returns the list of all product containing in database.
	 */
	@Override
	public ArrayList<User> exportUserData() throws FileNotSupportException, SQLException, InvalidUserProductException {
		User userObj = null;
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		ArrayList<User> UserList = new ArrayList<>();
		try {
			con = DBConnectionUtil.getconnection();
			LOGGER_OBJ.debug(con);
			stmt = con.createStatement();
			rs = stmt.executeQuery(USEER_selectQUERY);
			while (rs.next()) {
				userObj = new User();
				userObj.setUserId(rs.getString(1));
				userObj.setUserName(rs.getString(2));
				userObj.setEmail(rs.getString(3));
				userObj.setPhoneNumber(rs.getString(4));
				userObj.setCity(rs.getString(5));
				UserList.add(userObj);
			}
			LOGGER_OBJ.debug(UserList);
			return UserList;

		} catch (SQLException ex) {
			throw new GeneralSqlException("Issue in the connection", ex);
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new GeneralSqlException("Issue in the connection", e);
				}

			} else if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					throw new GeneralSqlException("Issue in the connection", e);
				}

			} else if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					throw new GeneralSqlException("Issue in the connection", e);
				}

			}
		}

	}
}
