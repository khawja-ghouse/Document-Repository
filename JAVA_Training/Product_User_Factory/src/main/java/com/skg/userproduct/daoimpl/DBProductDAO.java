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
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.skg.userproduct.daointerface.IProductDAO;
import com.skg.userproduct.exception.FileNotSupportException;
import com.skg.userproduct.exception.GeneralSqlException;
import com.skg.userproduct.exception.InvalidUserProductException;
import com.skg.userproduct.model.Product;
import com.skg.userproduct.util.DBConnectionUtil;

/**
 * DBProductDAO :: DBProductDAO class is used to provide the implementation for
 * the exporting product data to the Database and importing the data from the
 * same and return it as list.
 * 
 * @author Khawja
 * @version 1.0
 */
public class DBProductDAO implements IProductDAO {
	/**
	 * Creating the Logger object called log that is used to get the logging
	 * information of UserCSVReader class
	 */
	final static Logger LOGGER_OBJ = LoggerFactory.getLogger(DBProductDAO.class);

	private static final String ProductCS_FILENAME = "Product.csv";
	private static final String SEPERATOR = "/";
	private static final String SEPERATOR_COMMA = ",";
	private static final String PRODUCT_QUERY = "INSERT INTO PRODUCT VALUES(?,?,?,?)";
	private static final String PRODUCT_selectQUERY = "SELECT * FROM PRODUCT";
	private static final String PRODUCT_CITYQUESY = "INSERT INTO productcity VALUES(?,?)";
	private static final String PRODUCTCITY_SELECTQUERY = "SELECT * FROM PRODUCTCITY";
	/**
	 * Creating the classLoader object through which we can read the resources.
	 */
	ClassLoader classLoader = getClass().getClassLoader();

	/**
	 * importProductData():: Method used to insert the CSV file data to the
	 * database. The product data such as name, id , category ,price into the
	 * Product table in the database and product id and available city into the
	 * productcity table.
	 * 
	 * @throws InvalidUserProductException
	 * @throws FileNotSupportException
	 * @throws GeneralSqlException
	 * @return returns true if inserted successfully and false if there is some
	 *         exception.
	 */
	public boolean importProductData()
			throws InvalidUserProductException, FileNotSupportException, GeneralSqlException {

		File file = new File(classLoader.getResource(ProductCS_FILENAME).getFile());
		/**
		 * String line: String fields[] array that contains user data after spiting.
		 */
		String line, fileds[];
		boolean skipLine = true;
		try (FileReader fin = new FileReader(file); BufferedReader bin = new BufferedReader(fin)) {
			while ((line = bin.readLine()) != null) {
				if (skipLine) {
					skipLine = false;
					continue;
				}
				LOGGER_OBJ.debug(line);
				ArrayList<String> avlist = new ArrayList<String>();
				Product productObj = new Product();
				fileds = line.split(SEPERATOR_COMMA);
				LOGGER_OBJ.debug(Arrays.toString(fileds));
				productObj.setProductId(fileds[0]);
				productObj.setProductName(fileds[1]);
				productObj.setProductCategory(fileds[2]);
				productObj.setPrice(Double.parseDouble(fileds[3]));
				String[] s1 = fileds[4].split(SEPERATOR);
				for (int i = 0; i < s1.length; i++) {
					avlist.add(s1[i]);
				}
				productObj.setAvailableCity(avlist);
				LOGGER_OBJ.debug("Available Product List :: " + avlist);
				addProduct(productObj);
			}
			LOGGER_OBJ.debug("done with exporting product DB");
		} catch (NumberFormatException e) {
			throw new InvalidUserProductException("Invalid format exception", e);
		} catch (NullPointerException e) {
			throw new InvalidUserProductException("there is a null pointing exception", e);
		} catch (IOException e) {
			LOGGER_OBJ.error("Issue in the file Provided");
			throw new FileNotSupportException("Issue in the file Provided", e);
		} catch (SQLException e) {
			throw new GeneralSqlException("Issue in the file Provided", e);
		}
		return true;
	}

	/**
	 * addProduct():: The method used to add the product to the database table
	 * specified.
	 * 
	 * @param productObj the product that should be added to the database.
	 * @throws FileNotSupportException
	 * @throws InvalidUserProductException
	 * @throws SQLException
	 */
	public void addProduct(Product productObj)
			throws FileNotSupportException, InvalidUserProductException, SQLException {
		Connection con = DBConnectionUtil.getconnection();
		PreparedStatement prstmt = null;
		PreparedStatement prst = null;
		try {
			prstmt = con.prepareStatement(PRODUCT_QUERY);
			prstmt.setString(1, productObj.getProductId());
			prstmt.setString(2, productObj.getProductName());
			prstmt.setString(3, productObj.getProductCategory());
			prstmt.setDouble(4, productObj.getPrice());
			prstmt.executeUpdate();
			Iterator<String> siterator = productObj.getAvailableCity().iterator();
			while (siterator.hasNext()) {
				prst = con.prepareStatement(PRODUCT_CITYQUESY);
				prst.setString(1, productObj.getProductId());
				prst.setString(2, siterator.next());
				prst.executeUpdate();
			}
		} catch (SQLException e) {
			throw new GeneralSqlException("Issue in the connection", e);
		} finally {
			if (prstmt != null) {
				try {
					prstmt.close();
				} catch (SQLException e) {
					throw new GeneralSqlException("Issue in the connection", e);
				}
			} else if (prst != null) {
				try {
					prst.close();
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
	 * exportProductData():: Method used to retrieve the data from the Database and
	 * then store in the List.
	 * 
	 * @return ::returns the list of all product containing in database.
	 */
	public List<Product> exportProductData() throws SQLException, FileNotSupportException, InvalidUserProductException {
		Product p = null;
		Connection con = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		Statement stmt = null;
		Statement stmt1 = null;
		ArrayList<Product> Productlist = new ArrayList<>();
		try {
			con = DBConnectionUtil.getconnection();
			stmt = con.createStatement();
			stmt1 = con.createStatement();
			rs = stmt.executeQuery(PRODUCT_selectQUERY);
			while (rs.next()) {
				ArrayList<String> avlist = new ArrayList<String>();
				p = new Product();
				p.setProductId(rs.getString(1));
				p.setProductName(rs.getString(2));
				p.setProductCategory(rs.getString(3));
				p.setPrice(rs.getDouble(4));
				rs1 = stmt1.executeQuery(PRODUCTCITY_SELECTQUERY);
				while (rs1.next()) {
					if (p.getProductId().equals(rs1.getString(1))) {
						avlist.add(rs1.getString(2));
					}
				}
				p.setAvailableCity(avlist);
				Productlist.add(p);
			}
			LOGGER_OBJ.debug("Product List ::" + Productlist);
			return Productlist;

		} catch (SQLException ex) {
			throw new GeneralSqlException("Issue in the connection", ex);
		} finally {
			if (rs1 != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					throw new GeneralSqlException("Issue in the connection", e);
				}

			}
			if (stmt1 != null) {
				try {
					stmt1.close();
				} catch (SQLException e) {
					throw new GeneralSqlException("Issue in the connection", e);
				}
			} else if (rs != null) {
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

	public static void main(String[] args) throws FileNotSupportException, SQLException, InvalidUserProductException {
		DBProductDAO d = new DBProductDAO();
		System.out.println(d.exportProductData());
	}
}
