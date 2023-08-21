package com.skg.userproduct.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import com.skg.userproduct.daointerface.IProductDAO;
import com.skg.userproduct.daointerface.IUserDAO;
import com.skg.userproduct.exception.FileNotSupportException;
import com.skg.userproduct.exception.InvalidUserProductException;
import com.skg.userproduct.factory.DAOFactory;
import com.skg.userproduct.interfaces.IProductAvailabilityService;
import com.skg.userproduct.model.Product;
import com.skg.userproduct.model.User;

/**
 * ProductAvailabilityService class that is used to implement the methods
 * 1.getAllProductForUser()::method used to get all those products that are
 * available in city of the user. 2.getAllProductForUserForCategory()::method
 * used to get all those products that are available in city of the userand
 * given category
 * 
 * @author Khawja
 * @version 1.0
 */
public class ProductAvailabilityService implements IProductAvailabilityService {
	/**
	 * Creating the classLoader object through which we can read the resources.
	 */
	final static Logger LOGGER_OBJ = Logger.getLogger(ProductAvailabilityService.class);
	private List<Product> productList;
	private List<User> userList;
	DAOFactory factoryObj = DAOFactory.getInstance();
	IProductDAO productDAO = factoryObj.getProductDAOInstance();
	IUserDAO userDAO = factoryObj.getUserDAOInstance();

	/**
	 * Constructor used to get the Userlist and productlist
	 * 
	 * @throws InvalidUserProductException
	 * @throws SQLException
	 * @throws IOException
	 */
	public ProductAvailabilityService() throws InvalidUserProductException, SQLException, IOException {
		this.userList = userDAO.exportUserData();
		this.productList = productDAO.exportProductData();
		LOGGER_OBJ.info("from ProductAvailabilityService() constructor::\n" + userList);
		LOGGER_OBJ.info("from ProductAvailabilityService() constructor::\n" + productList);
	}

	/**
	 * getAllProductForUser():: get the user from the instance variable userList for
	 * the given userId then find the city of the Selected User. Iterate over the
	 * productList and find all those products that are available in city of the
	 * user
	 * 
	 * @param userId :: for the user id you want to find the product list.
	 * @return returned List<Product> in the productList instance variable for the
	 *         city selected.
	 * @throws InvalidUserProductException
	 * @throws SQLException
	 * @throws IOException
	 * @throws FileNotSupportException
	 * 
	 */

	public List<Product> getAllProductForUser(String userId)
			throws InvalidUserProductException, SQLException, FileNotSupportException, IOException {

		List<User> userLObj = userDAO.exportUserData();
		List<Product> prodLobj = productDAO.exportProductData();

		User user = userLObj.stream().filter(uobj -> uobj.getUserId().equals(userId)).findAny().orElse(null);
		String city = user.getCity();
		LOGGER_OBJ.debug("The selected user city::" + city);

		List<Product> listP = prodLobj.stream().filter(prod -> prod.getAvailableCity().contains(city))
				.collect(Collectors.toList());

		//prodLobj.stream().filter(product -> product.getAvailableCity().contains(city)).forEach(System.out::println);
		
		prodLobj.stream()
		        .filter(prod -> prod.getAvailableCity().contains(city))
		        .filter(product -> product.getProductCategory().equalsIgnoreCase("Laptop"))
		        .forEach(System.out::println);
		
		return listP;

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
	 * @throws SQLException
	 * @throws IOException
	 */
	public List<Product> getAllProductForUserForCategory(String userId, String productCategory)
			throws InvalidUserProductException, SQLException, IOException {
		// ArrayList<Product> productList1 = new ArrayList<>();
		ArrayList<Product> productList2 = (ArrayList<Product>) getAllProductForUser(userId);

		List<Product> productList1 = productList2.stream()
				.filter(prod -> prod.getProductCategory().equals(productCategory)).collect(Collectors.toList());

		LOGGER_OBJ.debug("The list of product with the given userID and category::" + productList1);
		return productList1;
	}

	public static void main(String[] args) throws FileNotSupportException, InvalidUserProductException, SQLException {

		ProductAvailabilityService pas;
		try {
			pas = new ProductAvailabilityService();
			LOGGER_OBJ.debug(pas.getAllProductForUser("U1004"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
