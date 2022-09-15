package com.skg.productuser.csvreader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import com.skg.productuser.dao.ProductUserDAO;
import com.skg.productuser.exception.FileNotSupportException;
import com.skg.productuser.exception.GeneralSqlException;
import com.skg.productuser.exception.InvalidUserProductException;
import com.skg.productuser.model.Product;

/**
 * ProductCSVReader Class used to Read the content of each product from the
 * given CSV file
 * 
 * @author Khawja
 * @version 1.0
 */
public class ProductCSVImportToDB {
	/**
	 * Creating the Logger object called log that is used to get the logging
	 * information of UserCSVReader class
	 */
	final static Logger LOGGER_OBJ = Logger.getLogger(ProductCSVImportToDB.class);
	private static final String ProductCS_FILENAME = "Product.csv";
	private static final String SEPERATOR = "/";
	private static final String SEPERATOR_COMMA = ",";
	private static final String USERCS_FILENAME = "User.csv";

	/**
	 * getAllProducts():: This is a method used to read each product data into a
	 * unique product instances then adding this instances to the ArrayList object .
	 * 
	 * @return returns the ArrayList that contains all product instances.
	 * @throws FileNotSupportException     :: Used to throw Exception which occur
	 *                                     during execution
	 * @throws InvalidUserProductException
	 * @throws GeneralSqlException
	 * @throws SQLException
	 */
	public void getAllProductsToDB() throws FileNotSupportException, InvalidUserProductException, GeneralSqlException {
		/**
		 * Creating the classLoader object through which we can read the resources.
		 */
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(ProductCS_FILENAME).getFile());
		/**
		 * String line: String fileds[] array that contains user data after spliting.
		 */
		ProductUserDAO pudao = new ProductUserDAO();
		String line, fileds[];
		boolean skipLine = true;
		ArrayList<Product> ProductList = new ArrayList<Product>();
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
				LOGGER_OBJ.debug(avlist);
				pudao.addProduct(productObj);
			}
		} catch (NumberFormatException e) {
			throw new InvalidUserProductException("Invalid format exception", e);
		} catch (NullPointerException e) {
			throw new InvalidUserProductException("there is a null pointing exception", e);
		} catch (IOException e) {
			LOGGER_OBJ.error("Issue in the file Provided");
			throw new FileNotSupportException("Issue in the file Provided", e);
		} catch (SQLException e) {
			throw new GeneralSqlException("Issue in the connection", e);
		}
	}
	public static void main(String[] args) throws FileNotSupportException, InvalidUserProductException, SQLException {
		ProductCSVImportToDB p = new ProductCSVImportToDB();
		ProductUserDAO pdaoObj = new ProductUserDAO();
		p.getAllProductsToDB();
		pdaoObj.getProducts();
	}
}
