package com.skg.userproduct.daointerface;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.skg.userproduct.exception.FileNotSupportException;
import com.skg.userproduct.exception.GeneralSqlException;
import com.skg.userproduct.exception.InvalidUserProductException;
import com.skg.userproduct.model.Product;

/**
 * IProductDAO:: IProductDAO is the implementation for abstract methods like.
 * importtProductData() => Import the data to the Database. exportProductData()
 * => get the product list from Database or CSV file.
 * 
 * @author Khawja
 * @version 1.0
 */
public interface IProductDAO {

	boolean importProductData() throws InvalidUserProductException, FileNotSupportException, GeneralSqlException;

	List<Product> exportProductData()
			throws FileNotSupportException, InvalidUserProductException, SQLException, IOException;

}
