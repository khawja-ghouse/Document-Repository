package com.skg.productuser;

import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.skg.userproduct.daointerface.IProductDAO;
import com.skg.userproduct.exception.FileNotSupportException;
import com.skg.userproduct.exception.InvalidUserProductException;
import com.skg.userproduct.factory.DAOFactory;
import com.skg.userproduct.model.Product;

public class FileProductDAOTest {

	final static Logger LOGGER_OBJ = LoggerFactory.getLogger(FileProductDAOTest.class);
	private static final String ProductCS_FILENAME = "Product.csv";
	private static final String SEPERATOR = "/";
	private static final String SEPERATOR_COMMA = ",";

	ClassLoader classLoader = getClass().getClassLoader();
	DAOFactory factoryObj = DAOFactory.getInstance();
	IProductDAO fpObj = factoryObj.getProductDAOInstance();

	@Test
	public void ExportProductDataTest() throws InvalidUserProductException, SQLException, IOException {
		File file = new File(classLoader.getResource(ProductCS_FILENAME).getFile());
		String line, fileds[];
		boolean skipLine = true;
		ArrayList<Product> ProductList = new ArrayList<Product>();
		try (FileReader fin = new FileReader(file); BufferedReader bin = new BufferedReader(fin)) {
			while ((line = bin.readLine()) != null) {
				if (skipLine) {
					skipLine = false;
					continue;
				}
				ArrayList<String> avlist = new ArrayList<>();
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
		assertEquals(true, fpObj.exportProductData());
		assertEquals(ProductList, fpObj.importProductData());
	}

}
