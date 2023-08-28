package com.skg.userproduct.daoimpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opencsv.CSVWriter;
import com.skg.userproduct.daointerface.IProductDAO;
import com.skg.userproduct.exception.FileNotSupportException;
import com.skg.userproduct.exception.GeneralSqlException;
import com.skg.userproduct.exception.InvalidUserProductException;
import com.skg.userproduct.model.Product;

/**
 * FileProductDAO :: FileProductDAO class is used to provide the implementation
 * for the importing product data to another the CSV file and exporting the
 * product from the same and return it as list.
 * 
 * @author Khawja
 * @version 1.0
 */
public class FileProductDAO implements IProductDAO {
	/**
	 * Creating the Logger object called log that is used to get the logging
	 * information of FileProductDAO class
	 */
	final static Logger LOGGER_OBJ = LoggerFactory.getLogger(FileProductDAO.class);
	private static final String ProductCS_FILENAME = "Product.csv";
	private static final String EXPORTED_PRODUCT_LIST = "importProduct.csv";
	private static final String SEPERATOR = "/";
	private static final String SEPERATOR_COMMA = ",";

	/**
	 * importProductData():: Method used to insert the CSV file data to the
	 * another CSV file . The product data such as name, id , category ,price
	 * into the one CSV file.
	 * 
	 * @throws InvalidUserProductException
	 * @throws FileNotSupportException
	 * @throws GeneralSqlException
	 * @return returns true if inserted successfully and false if there is some
	 *         exception.
	 */
	@Override
	public boolean importProductData() {
		/**
		 * Creating the classLoader object through which we can read the
		 * resources.
		 */
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(ProductCS_FILENAME).getFile());
		String line, fileds[];
		try (FileWriter fout = new FileWriter(EXPORTED_PRODUCT_LIST);
				CSVWriter writer = new CSVWriter(fout, ',', CSVWriter.NO_QUOTE_CHARACTER,
						CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
				FileReader fin = new FileReader(file);
				BufferedReader bin = new BufferedReader(fin)) {
			while ((line = bin.readLine()) != null) {
				fileds = line.split(SEPERATOR_COMMA);
				writer.writeNext(fileds);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		LOGGER_OBJ.debug("Done with exporting Product data");
		return true;
	}

	/**
	 * exportProductData():: Method used to retrieve the data from the
	 * ProductCSV and then store in the List.
	 * 
	 * @return ::returns the list of all product containing in CSV file.
	 * @throws IOException
	 */
	@Override
	public List<Product> exportProductData() throws InvalidUserProductException, IOException {
		/**
		 * Creating the classLoader object through which we can read the
		 * resources.
		 */
		ClassLoader classLoader = getClass().getClassLoader();
		String file = classLoader.getResource(ProductCS_FILENAME).getFile();
		/**
		 * String line: String fields[] array that contains user data after
		 * spiting.
		 */
		ArrayList<Product> ProductList = new ArrayList<Product>();
		Files.lines(new File(file).toPath()).skip(1).map(s2 -> s2.trim()).forEach(linen -> {
			Product productObj = new Product();
			String[] fileds = linen.split(SEPERATOR_COMMA);
			productObj.setProductId(fileds[0]);
			productObj.setProductName(fileds[1]);
			productObj.setProductCategory(fileds[2]);
			productObj.setPrice(Double.parseDouble(fileds[3]));
			String[] s1 = fileds[4].split(SEPERATOR);
			ArrayList<String> avlist = new ArrayList<>();
			for (int i = 0; i < s1.length; i++) {
				avlist.add(s1[i]);
			}
			productObj.setAvailableCity(avlist);
			ProductList.add(productObj);
		});

		return ProductList;
	}
}
