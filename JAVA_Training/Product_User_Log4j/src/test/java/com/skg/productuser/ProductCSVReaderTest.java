package com.skg.productuser;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.skg.productuser.csvreader.ProductCSVReader;
import com.skg.productuser.exception.FileNotSupportException;
import com.skg.productuser.exception.InvalidUserProductException;
import com.skg.productuser.model.Product;

public class ProductCSVReaderTest {
	public static final String PRODUCT_FILENAME = "Product.csv";
	public static final String SEPERATOR = "/";
	public static final String SEPERATOR_COMMA = ",";

	@Test
	public void getAllProductsTest() throws FileNotSupportException, InvalidUserProductException {
		ProductCSVReader productReader = new ProductCSVReader();
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(PRODUCT_FILENAME).getFile());

		String line, fileds[];
		boolean skipLine = true;
		ArrayList<Product> productList = new ArrayList<Product>();
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
				productList.add(productObj);
			}
		} catch (NumberFormatException e) {
			throw new InvalidUserProductException("Invalid format exception", e);
		} catch (NullPointerException e) {
			throw new InvalidUserProductException("there is a null pointing exception", e);
		} catch (IOException e) {
			throw new FileNotSupportException("Issue in the file Provided", e);
		}
		assertEquals(productList, productReader.getAllProducts());
	}

}
