package com.skg.rest.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.skg.rest.entity.City;
import com.skg.rest.exception.InvalidFileNameException;

public class CityUtil {
	private static final Logger logger = LoggerFactory.getLogger(CityUtil.class);

	/**
	 * this method is for getting the All City data from the File.
	 * 
	 * @return returns the List of city of All city present in the File
	 * @throws InvalidFileNameException if FileName will not found in the given path
	 *                                  location
	 * @throws NumberFormatException    if id will not properly formatted in the
	 *                                  file
	 */
	public static List<City> getAllCityList() throws InvalidFileNameException {
		logger.info("getAllCityList method started ...");
		List<City> cityList = new ArrayList();
		InputStream inputStream = CityUtil.class.getClassLoader().getResourceAsStream("CityExercise.csv");
		if (inputStream == null) {
			throw new InvalidFileNameException("This file is not available please Choose the Valid fileName ");
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
		try {
			String line = br.readLine();
			String[] cityRecord;
			while ((line = br.readLine()) != null) {
				cityRecord = line.split(",");
				City city = new City();
				String name = cityRecord[1];
				String countryCode = cityRecord[2];
				String district = cityRecord[3];
				city.setName(name);
				city.setCountryCode(countryCode);
				city.setDistrict(district);
				try {
					Integer id = Integer.parseInt(cityRecord[0]);
					Long popuation = Long.parseLong(cityRecord[4]);
					city.setId(id);
					city.setPopulation(popuation);
					cityList.add(city);
				} catch (NumberFormatException ex) {
					logger.error("Id is not properly formatted in the File " + ex);
				}
			}
		} catch (IOException ex) {
			logger.error(ex + "");
		}
		logger.info("getAllCityList method executed successfully");
		logger.info("File has been read successfully");
		return cityList;
	}

}
