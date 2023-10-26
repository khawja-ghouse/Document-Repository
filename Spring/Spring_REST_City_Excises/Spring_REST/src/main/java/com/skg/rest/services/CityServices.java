package com.skg.rest.services;

import java.util.List;

import com.skg.rest.entity.City;
import com.skg.rest.exception.CountryCodeNotFoundException;
import com.skg.rest.exception.IdNotFoundException;

public interface CityServices {

	/**
	 * this method is for getting Maximum populated City from the File
	 * 
	 * @param cityRecord is the list of all city
	 * @return returns the City which is having Maximum Population
	 */
	City getMaxPopulatedCity(List<City> cityRecord);

	/**
	 * this method is for getting minimum populated City from the File
	 * 
	 * @param cityRecord is the list of all city
	 * @return returns the City having Minimum Population
	 */
	City getMinPopulatedCity(List<City> cityRecord);

	/**
	 * this method is for getting the City from a specified id.
	 * 
	 * @param cityRecord is the list of all city
	 * @param givenId    is the id to get the specific city
	 * @return returns City of a specific id
	 * @throws IdNotFoundException if supplied id is not available in the file
	 */
	City getCityById(List<City> cityRecord, int givenId) throws IdNotFoundException;

	/**
	 * this method is for getting the List Of City from a specified Country Code.
	 * 
	 * @param cityRecord       is the list of all city
	 * @param givenCountryCode is the code to get the list of all city with specific
	 *                         to this code.
	 * @return the list of city from specified Country Code.
	 * @throws CountryCodeNotFoundException if supplied countryCode is not available
	 *                                      in the file
	 */
	List<City> getCityByCountryCode(List<City> cityRecord, String givenCountryCode) throws CountryCodeNotFoundException;

}
