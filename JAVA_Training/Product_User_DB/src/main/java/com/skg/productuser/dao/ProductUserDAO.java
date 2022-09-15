package com.skg.productuser.dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;

import com.skg.productuser.exception.FileNotSupportException;
import com.skg.productuser.exception.GeneralSqlException;
import com.skg.productuser.model.Product;
import com.skg.productuser.model.User;
import com.skg.productuser.util.DBConnectionUtil;

public class ProductUserDAO {
	public static final String SEPERATOR_COMMA = ",";
	final static Logger LOGGER_OBJ = Logger.getLogger(ProductUserDAO.class);
	public static final String USEER_QUERY = "INSERT INTO USER VALUES(?,?,?,?,?)";
	public static final String PRODUCT_QUERY = "INSERT INTO PRODUCT VALUES(?,?,?,?)";
	public static final String USEER_selectQUERY = "SELECT * FROM USER";
	public static final String PRODUCT_selectQUERY = "SELECT * FROM PRODUCT";
	public static final String PRODUCT_CITYQUESY = "INSERT INTO productcity VALUES(?,?)";

	public ArrayList<Product> getProducts() throws SQLException, FileNotSupportException {
		Product p = null;
		Connection con = null;
		ResultSet rs = null;
		ArrayList<Product> Productlist = new ArrayList<Product>();
		try {
			con = DBConnectionUtil.getConnection();
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(PRODUCT_selectQUERY);
			while (rs.next()) {
				ArrayList<String> avlist = new ArrayList<String>();
				p = new Product();
				p.setProductId(rs.getString(1));
				p.setProductName(rs.getString(2));
				p.setProductCategory(rs.getString(3));
				p.setPrice(rs.getDouble(4));
				Productlist.add(p);
			}
			LOGGER_OBJ.debug(Productlist);
			return Productlist;

		} catch (SQLException ex) {
			throw new GeneralSqlException("Issue in the connection", ex);
		} finally {
			if (rs != null) {
				rs.close();
			}
		}
	}

	public void addProduct(Product p) throws FileNotSupportException, SQLException {
		Connection con = DBConnectionUtil.getConnection();
		PreparedStatement prstmt = null;
		PreparedStatement prst = null;
		try {
			prstmt = con.prepareStatement(PRODUCT_QUERY);
			prstmt.setString(1, p.getProductId());
			prstmt.setString(2, p.getProductName());
			prstmt.setString(3, p.getProductCategory());
			prstmt.setDouble(4, p.getPrice());
			prstmt.executeUpdate();
			Iterator<String> siterator = p.getAvailableCity().iterator();
			while (siterator.hasNext()) {
				prst = con.prepareStatement(PRODUCT_CITYQUESY);
				prst.setString(1, p.getProductId());
				prst.setString(2, siterator.next());
				prst.executeUpdate();
			}
		} catch (SQLException e) {
			throw new GeneralSqlException("Issue in the connection", e);
		} finally {
			if (prstmt != null) {
				prstmt.close();
			} else if (prst != null) {
				prst.close();
			}
		}
	}

	public void addUsers(User userObj) throws SQLException, FileNotSupportException {
		Connection con = DBConnectionUtil.getConnection();
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
				prstmt.close();
			}
		}
	}

	public ArrayList<User> getAllUsers() throws FileNotSupportException, SQLException {
		User userObj = null;
		Connection con = null;
		ResultSet rs = null;
		ArrayList<User> UserList = new ArrayList<User>();
		try {
			con = DBConnectionUtil.getConnection();
			LOGGER_OBJ.debug(con);
			Statement stmt = con.createStatement();
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
			// TODO: handle exception
			throw new GeneralSqlException("Issue in the connection", ex);
		} finally {
			if (rs != null) {
				rs.close();
			}
		}
	}
}
