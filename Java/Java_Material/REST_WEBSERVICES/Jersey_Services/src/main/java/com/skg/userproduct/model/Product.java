package com.skg.userproduct.model;

import java.util.List;

/**
 * Product:: class that provides the Template of the Product.Where each Product
 * contains ProductId, ProductName,ProductCategory,Price and availableCity.
 * 
 * @author Khawja
 * @version 1.0
 */
public class Product {
	/**
	 * ProductId :: Id of the product
	 */
	private String ProductId;
	/**
	 * ProductName:: name of the product
	 */
	private String ProductName;
	/**
	 * ProductCategory::Category of the product
	 */
	private String ProductCategory;
	/**
	 * price :: price of the product
	 */
	private double price;
	/**
	 * A list that contains the name of cities where product is available
	 */
	private List<String> availableCity;

	/**
	 * getProductId() method used to get the productId of the Instance
	 * 
	 * @return ::returns the productId
	 */
	public String getProductId() {
		return ProductId;
	}

	/**
	 * setProductId() method used to set the productId of the Instance
	 * 
	 * @param productId :: The Id for the product you want to set .
	 */
	public void setProductId(String productId) {
		ProductId = productId;
	}

	/**
	 * getProductName() method used to get the ProductName of the Instance
	 * 
	 * @return ::returns the ProductName
	 */
	public String getProductName() {
		return ProductName;
	}

	/**
	 * setProductName() method used to set the ProductName of the Instance
	 * 
	 * @param ProductName :: The ProductName for the product you want to set .
	 */
	public void setProductName(String productName) {
		ProductName = productName;
	}

	/**
	 * getProductCategory() method used to get the ProductCategory of the Instance
	 * 
	 * @return ::returns the ProductCategory
	 */
	public String getProductCategory() {
		return ProductCategory;
	}

	/**
	 * setProductCategory() method used to set the ProductCategory of the Instance
	 * 
	 * @param ProductName :: The ProductCategory for the product you want to set .
	 */
	public void setProductCategory(String productCategory) {
		ProductCategory = productCategory;
	}

	/**
	 * getPrice() method used to get the price of the Instance
	 * 
	 * @return ::returns the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * setPrice() method used to set the price of the Instance
	 * 
	 * @param price :: The price for the product you want to set .
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * getAvailableCity() method used to get the list of availableCity of the
	 * Instance
	 * 
	 * @return ::returns the List of cities
	 */
	public List<String> getAvailableCity() {
		return availableCity;
	}

	public void setAvailableCity(List<String> availableCity) {
		this.availableCity = availableCity;
	}

	/**
	 * toString() :: Used to print the each instance in a Required format.
	 */
	@Override
	public String toString() {
		return "Product [ProductId=" + ProductId + ", ProductName=" + ProductName + ", ProductCategory="
				+ ProductCategory + ", price=" + price + ", availableCity=" + availableCity + "]";
	}

	/**
	 * hashCode() :: The general contract of hashCode is: Whenever it is invoked on
	 * the same object more than once during an execution of a Java application, the
	 * hashCode method must consistently return the same integer, provided no
	 * information used in equals comparisons on the object is modified
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ProductCategory == null) ? 0 : ProductCategory.hashCode());
		result = prime * result + ((ProductId == null) ? 0 : ProductId.hashCode());
		result = prime * result + ((ProductName == null) ? 0 : ProductName.hashCode());
		result = prime * result + ((availableCity == null) ? 0 : availableCity.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/**
	 * equals() :: Java String equals() method overrides the Object class equals()
	 * method implementation. Since String is immutable, checking the equality of
	 * string to another object should be done using equals() method rather than ==
	 * operator. String equals() method always return boolean value, it doesn't
	 * throw any exceptions
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (ProductCategory == null) {
			if (other.ProductCategory != null)
				return false;
		} else if (!ProductCategory.equals(other.ProductCategory))
			return false;
		if (ProductId == null) {
			if (other.ProductId != null)
				return false;
		} else if (!ProductId.equals(other.ProductId))
			return false;
		if (ProductName == null) {
			if (other.ProductName != null)
				return false;
		} else if (!ProductName.equals(other.ProductName))
			return false;
		if (availableCity == null) {
			if (other.availableCity != null)
				return false;
		} else if (!availableCity.equals(other.availableCity))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}

}
