package com.skg.productuser.csvreader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.skg.productuser.exception.FileNotSupportException;
import com.skg.productuser.exception.InvalidUserProductException;
import com.skg.productuser.model.Product;

/**
 * ProductCSVReader Class used to Read the content of each product from the
 * given CSV file
 * 
 * @author Khawja
 * @version 1.0
 */
public class ProductCSVReader {
	/**
	 * Creating the Logger object called log that is used to get the logging
	 * information of UserCSVReader class
	 */
	final static Logger LOGGER_OBJ = Logger.getLogger(ProductCSVReader.class);
	public static final String ProductCS_FILENAME = "Product.csv";
	public static final String SEPERATOR = "/";
	public static final String SEPERATOR_COMMA = ",";

	/**
	 * getAllProducts():: This is a method used to read each product data into a
	 * unique product instances then adding this instances to the ArrayList object .
	 * 
	 * @return returns the ArrayList that contains all product instances.
	 * @throws FileNotSupportException     :: Used to throw Exception which occur
	 *                                     during execution
	 * @throws InvalidUserProductException
	 */
	public List<Product> getAllProducts() throws FileNotSupportException, InvalidUserProductException {
		/**
		 * Creating the classLoader object through which we can read the resources.
		 */
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(ProductCS_FILENAME).getFile());
		String s = file.getName();
		/**
		 * String line: String fileds[] array that contains user data after spliting.
		 */
		String line, fileds[];
		boolean skipLine = true;
		ArrayList<Product> ProductList = new ArrayList<Product>();
		try (FileReader fin = new FileReader(file); BufferedReader bin = new BufferedReader(fin)) {
			while ((line = bin.readLine()) != null) {
				if (skipLine) {
					skipLine = false;
					continue;
				}
				ArrayList<String> avlist = new ArrayList<String>();
				Product productObj = new Product();
				fileds = line.split(SEPERATOR_COMMA);
				productObj.setProductId(fileds[0]);
				productObj.setProductName(fileds[1]);
				productObj.setProductCategory(fileds[2]);
				productObj.setPrice(Double.parseDouble(fileds[3]));
				String[] s1 = fileds[4].split(SEPERATOR);
				for (int i = 0; i < s1.length; i++) {
					avlist.add(s1[i]);
				}
				productObj.setAvailableCity(avlist);
				ProductList.add(productObj);
			}
			LOGGER_OBJ.debug("Product Information::" + ProductList);
		} catch (NumberFormatException e) {
			throw new InvalidUserProductException("Invalid format exception", e);
		} catch (NullPointerException e) {
			throw new InvalidUserProductException("there is a null pointing exception", e);
		} catch (IOException e) {
			LOGGER_OBJ.error("Issue in the file Provided");
			throw new FileNotSupportException("Issue in the file Provided", e);
		}
		return ProductList;

	}

//	public static void main(String[] args) 
//	{
//		ProductCSVReader p = new ProductCSVReader();
//		p.getAllProducts();
//	}
}
