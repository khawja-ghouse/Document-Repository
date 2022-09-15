package com.skg.productuser.model;

/**
 * User :: class that provides the Template of the User.Where each User contains
 * userName, userId,email,phoneNumber and city.
 * 
 * @author Khawja
 * @version 1.0
 */
public class User {
	/**
	 * userName :: userName of the User
	 */
	private String userName;
	/**
	 * userId :: Id of the User
	 */
	private String userId;
	/**
	 * email :: email of the User
	 */
	private String email;
	/**
	 * phoneNumber :: phoneNumber of the User
	 */
	private String phoneNumber;
	/**
	 * City :: city of the user
	 */
	private String city;

	/**
	 * getUserName():: method used to get the username of the Instance.
	 * 
	 * @return returns the username
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * setUserName() method used to set the UserName of the Instance
	 * 
	 * @param setUserName :: The UserName for the user you want to set .
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * getUserId():: method used to get the userId of the Instance.
	 * 
	 * @return returns the userID
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * setUserId() method used to set the UserId of the Instance
	 * 
	 * @param UserId :: The UserId for the user you want to set .
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * email():: method used to get the email of the Instance.
	 * 
	 * @return returns the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * setEmail() method used to set the Email of the Instance
	 * 
	 * @param Email :: The Email for the user you want to set .
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * getPhoneNumber():: method used to get the phoneNumber of the Instance.
	 * 
	 * @return returns the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * setPhoneNumber():: method used to set the phoneNumber of the Instance.
	 * 
	 * @param:: phoneNumber that you want to set for the user
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * getCity():: method used to get the city of the Instance.
	 * 
	 * @return returns the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * setCity() method used to set the City of the Instance
	 * 
	 * @param City :: The City for the user you want to set .
	 */
	public void setCity(String city) {
		this.city = city;
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
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		User other = (User) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	/**
	 * toString() :: Used to print the each instance in a Required format.
	 */
	@Override
	public String toString() {
		return "User [userName=" + userName + ", userId=" + userId + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", city=" + city + "]";
	}

}
