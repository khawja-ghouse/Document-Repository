package com.skg.productuser.services.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;

import com.skg.productuser.csvreader.ProductCSVReader;
import com.skg.productuser.csvreader.UserCSVReader;
import com.skg.productuser.exception.FileNotSupportException;
import com.skg.productuser.exception.InvalidUserProductException;
import com.skg.productuser.model.Product;
import com.skg.productuser.model.User;

/**
 * ProductAvailabilityService class that is used to implement the methods
 * 1.getAllProductForUser()::method used to get all those products that are
 * available in city of the user 2.getAllProductForUserForCategory()::method
 * used to get all those products that are available in city of the userand
 * given category
 * 
 * @author Khawja
 * @version 1.0
 */
public class ProductAvailabilityService {
	/**
	 * Creating the classLoader object through which we can read the resources.
	 */
	final static Logger LOGGER_OBJ = Logger.getLogger(ProductCSVReader.class);
	private List<Product> productList;
	private List<User> userList;

	/**
	 * Constructor used to get the Userlist and productlist
	 * 
	 * @throws FileNotSupportException
	 * @throws InvalidUserProductException
	 */
	public ProductAvailabilityService() throws FileNotSupportException, InvalidUserProductException {

		ProductCSVReader productobj = new ProductCSVReader();
		UserCSVReader userobj = new UserCSVReader();
		this.userList = userobj.getAllUser();
		this.productList = productobj.getAllProducts();
		LOGGER_OBJ.info("from ProductAvailabilityService() constructor::\n" + userList);
		LOGGER_OBJ.info("from ProductAvailabilityService() constructor::\n" + productList);
	}

	/**
	 * getAllProductForUser():: get the user from the instance variable userList for
	 * the given userId then pind the city of the Selected User. Iterate over the
	 * productList and find all those products that are available in city of the
	 * user
	 * 
	 * @param userId :: for the user id you want to find the product list.
	 * @return returned List<Product> in the productList instance variable for the
	 *         city selected.
	 * @throws FileNotSupportException
	 * @throws InvalidUserProductException
	 */
	public List<Product> getAllProductForUser(String userId)
			throws FileNotSupportException, InvalidUserProductException {

		if (userList == null) {
			LOGGER_OBJ.debug("loading.......\n\n");
			UserCSVReader userobj = new UserCSVReader();
			userList = userobj.getAllUser();
		}
		if (productList == null) {
			LOGGER_OBJ.debug("loading.......\n\n");
			ProductCSVReader prodobj = new ProductCSVReader();
			productList = prodobj.getAllProducts();
		}
//		if(productList == null)
//		{
//			ProductAvailabilityService productserviceobj = new ProductAvailabilityService();
//		}
		// get the user from the instance variable userList for the given userId
		// get the city of the Selected User
		// Iterate over the productList and find all those products that are available
		// in city of the user
		ArrayList<Product> productListnew = new ArrayList<Product>();
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
		LOGGER_OBJ.debug("The List of product for the user city selected::" + productList);
		return productListnew;
	}

	/**
	 * getAllProductForUserForCategory():: get the user from the instance variable
	 * userList for the given userId then find the city of the Selected User.
	 * iterate over the list and find those product which matches the given category
	 * 
	 * @param userId               ::
	 * @param productCategory::the list of product list that matches the given
	 *                             userId and category.
	 * @return returned List<Product> in the productList instance variable for the
	 *         city selected.
	 * @throws InvalidUserProductException
	 */
	public List<Product> getAllProductForUserForCategory(String userId, String productCategory)
			throws FileNotSupportException, InvalidUserProductException {
		ProductAvailabilityService productAvaiService = new ProductAvailabilityService();
		ArrayList<Product> productList1 = new ArrayList<Product>();
		ArrayList<Product> productList2 = (ArrayList<Product>) productAvaiService.getAllProductForUser(userId);
		Iterator<Product> productIterator = productList2.iterator();

		while (productIterator.hasNext()) {
			Product productObj = productIterator.next();

			if (productObj.getProductCategory().equals(productCategory)) {
				productList1.add(productObj);
			}

		}
		LOGGER_OBJ.debug("The list of product with the given userID and category::" + productList1);
		return productList1;

		// call getAllProductForUser(userId) this will give all the product in the user
		// city
		// iterate over the list and find those product which matches the given category
	}

}
