package com.skg.productuser;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.skg.userproduct.exception.FileNotSupportException;
import com.skg.userproduct.exception.InvalidUserProductException;
import com.skg.userproduct.model.Product;
import com.skg.userproduct.model.User;
import com.skg.userproduct.services.ProductAvailabilityService;

public class ProductAvailabilityServiceTest {
	final static Logger LOGGER_OBJ = Logger.getLogger(ProductAvailabilityServiceTest.class);

	private static ArrayList<Product> productList = new ArrayList<>();
	private static ArrayList<User> userList = new ArrayList<>();

	public static final String USERCS_FILENAME = "User.csv";
	public static final String ProductCS_FILENAME = "Product.csv";
	public static final String SEPERATOR = "/";
	public static final String SEPERATOR_COMMA = ",";

	public ProductAvailabilityServiceTest() {
	}

	@BeforeClass
	public static void BeforM() throws InvalidUserProductException, FileNotSupportException {
		ClassLoader classLoader = new ClassLoader() {
		};
		classLoader.getClass().getClassLoader();
		File file1 = new File(classLoader.getResource(USERCS_FILENAME).getFile());
		String line1, fileds1[];

		File file = new File(classLoader.getResource(ProductCS_FILENAME).getFile());
		String line, fileds[];
		boolean skipLinep = true;
		boolean skipLineu = true;
		try (FileReader fin = new FileReader(file);
				BufferedReader bin = new BufferedReader(fin);

				FileReader fin1 = new FileReader(file1);
				BufferedReader bin1 = new BufferedReader(fin1)) {
			// to read the productList
			while ((line = bin.readLine()) != null) {
				if (skipLinep) {
					skipLinep = false;
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
			// to read the Userlist
			while ((line1 = bin1.readLine()) != null) {
				if (skipLineu) {
					skipLineu = false;
					continue;
				}
				User u1 = new User();
				fileds1 = line1.split(SEPERATOR_COMMA);
				u1.setUserId(fileds1[0]);
				u1.setUserName(fileds1[1]);
				u1.setEmail(fileds1[2]);
				u1.setPhoneNumber(fileds1[3]);
				u1.setCity(fileds1[4]);
				userList.add(u1);
			}
		} catch (NumberFormatException e) {
			throw new InvalidUserProductException("Invalid format exception", e);
		} catch (NullPointerException e) {
			throw new InvalidUserProductException("there is a null pointing exception", e);
		} catch (IOException e) {

			throw new FileNotSupportException("Issue in the file Provided", e);
		}
		LOGGER_OBJ.debug("UserList  ProductAvailabilityServiceTest userList ::" + userList);
		LOGGER_OBJ.debug("UserList  ProductAvailabilityServiceTest productlist ::" + productList);
	}

	@Test
	public void getAllProductForUsertest() throws InvalidUserProductException, SQLException, IOException {
		ProductAvailabilityService productAvobj = new ProductAvailabilityService();
//		System.out.println(productList);
//		System.out.println(userList);
		String userId = "U1005";
		ArrayList<Product> productListnew = new ArrayList<>();
		Iterator<User> useriterator = userList.iterator();
		User userobj = null;
		while (useriterator.hasNext()) {
			userobj = useriterator.next();
			if (userobj.getUserId().equals(userId)) {
				break;
			}
		}
		String city = userobj.getCity();
		LOGGER_OBJ.debug("The selected user city::" + city);

		Iterator<Product> productiterator2 = productList.iterator();
		while (productiterator2.hasNext()) {
			Product productObj = productiterator2.next();

			Iterator<String> Cityiterator = productObj.getAvailableCity().iterator();
			while (Cityiterator.hasNext()) {
				if (Cityiterator.next().equals(city)) {
					productListnew.add(productObj);
				}
			}

		}
		LOGGER_OBJ.debug("from main Product List" + productAvobj.getAllProductForUser(userId));
		LOGGER_OBJ.debug("from test product list" + productListnew);
		assertEquals(productListnew, productAvobj.getAllProductForUser(userId));
	}

	@Test
	public void getAllProductForUserForCategorytest() throws InvalidUserProductException, SQLException, IOException {
		ProductAvailabilityService productavobj = new ProductAvailabilityService();
		String userId = "U1005";
		String Category = "Mobile";
		Iterator<User> userIterator = userList.iterator();
		User userobj = null;
		while (userIterator.hasNext()) {
			userobj = userIterator.next();
			if (userobj.getUserId().equals(userId)) {
				break;
			}
		}
		String city = userobj.getCity();
		ArrayList<Product> productlist1 = new ArrayList<>();
		ArrayList<Product> productlist2 = new ArrayList<>();
		Iterator<Product> productiterator = productList.iterator();
		while (productiterator.hasNext()) {
			Product productobj = productiterator.next();

			Iterator<String> iterator3 = productobj.getAvailableCity().iterator();
			while (iterator3.hasNext()) {
				if (iterator3.next().equals(city)) {
					productlist1.add(productobj);
				}
			}
		}
		Iterator<Product> iterator = productlist1.iterator();

		while (iterator.hasNext()) {
			Product productobj = iterator.next();

			if (productobj.getProductCategory().equals(Category)) {
				productlist2.add(productobj);
			}

		}
		assertEquals(productlist2, productavobj.getAllProductForUserForCategory(userId, Category));

	}

}
