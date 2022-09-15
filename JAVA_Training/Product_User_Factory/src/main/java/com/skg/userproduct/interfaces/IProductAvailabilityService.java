package com.skg.userproduct.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.skg.userproduct.exception.FileNotSupportException;
import com.skg.userproduct.exception.InvalidUserProductException;
import com.skg.userproduct.model.Product;

/**
 * IProductAvailabilityService :: Interface which contains the abstract methods
 * like getAllProductForUser(String) => used to get the list of product for the
 * given UserID; getAllProductForUserForCategory(String , String ) => used to
 * get the lits of the product having the category of the user provided.
 * 
 * @author Khawja
 * @version 1.0
 */
public interface IProductAvailabilityService {

	public List<Product> getAllProductForUser(String userId)
			throws FileNotSupportException, InvalidUserProductException, SQLException, IOException;

	public List<Product> getAllProductForUserForCategory(String userId, String productCategory)
			throws FileNotSupportException, InvalidUserProductException, SQLException, IOException;
}
