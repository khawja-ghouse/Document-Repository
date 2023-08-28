package com.skg.productuser;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.skg.userproduct.daointerface.IProductDAO;
import com.skg.userproduct.exception.FileNotSupportException;
import com.skg.userproduct.exception.InvalidUserProductException;
import com.skg.userproduct.factory.DAOFactory;
import com.skg.userproduct.model.Product;

public class DBProductDAOTest {

	final static Logger LOGGER_OBJ = LoggerFactory.getLogger(DBProductDAOTest.class);
	private static final String ProductCS_FILENAME = "Product.csv";
	private static final String SEPERATOR_COMMA = ",";
	static ClassLoader classLoader = new ClassLoader() {
	};
	static DAOFactory factoryObj = null;
	static IProductDAO dbpobj = null;

	@BeforeClass
	public static void methodBeforClass() {
		classLoader.getClass().getClassLoader();
		factoryObj = DAOFactory.getInstance();
		dbpobj = factoryObj.getProductDAOInstance();
	}

	@Test
	public void exportProductDataTest() throws InvalidUserProductException, SQLException, IOException {
		File file = new File(classLoader.getResource(ProductCS_FILENAME).getFile());
		IProductDAO dbpobj = factoryObj.getProductDAOInstance();
		String line, fileds[];
		boolean skipLine = true;
		ArrayList<Product> ProductList = new ArrayList<Product>();
		try (FileReader fin = new FileReader(file); BufferedReader bin = new BufferedReader(fin)) {
			while ((line = bin.readLine()) != null) {
				if (skipLine) {
					skipLine = false;
					continue;
				}
				Product productObj = new Product();
				fileds = line.split(SEPERATOR_COMMA);
				productObj.setProductId(fileds[0]);
				productObj.setProductName(fileds[1]);
				productObj.setProductCategory(fileds[2]);
				productObj.setPrice(Double.parseDouble(fileds[3]));
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
		assertEquals(ProductList, dbpobj.importProductData());
		assertEquals(true, dbpobj.exportProductData());
	}

}
