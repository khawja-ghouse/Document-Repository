package com.skg.rest.services.impl;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.skg.rest.entity.City;
import com.skg.rest.exception.CountryCodeNotFoundException;
import com.skg.rest.exception.IdNotFoundException;
import com.skg.rest.services.CityServices;

@Service
public class CityServicesImpl implements CityServices {
	private static final Logger logger = LoggerFactory.getLogger(CityServicesImpl.class);

	@Override
	public City getMaxPopulatedCity(List<City> cityRecord) {
		logger.info("getMaxPopulatedCity method started...");
		City city = new City();
		city = cityRecord.stream().max(Comparator.comparing(City::getPopulation)).get();
		logger.info("getMaxPopulatedCity executed successfully");
		return city;
	}

	@Override
	public City getMinPopulatedCity(List<City> cityRecord) {
		logger.info("getMinPopulatedCity method started...");
		City city = new City();
		city = cityRecord.stream().min(Comparator.comparing(City::getPopulation)).get();
		logger.info("getMinPopulatedCity method executed successfully");
		return city;
	}

	@Override
	public City getCityById(List<City> cityRecord, int givenId) throws IdNotFoundException {
		logger.info("getCityById method started...");
		City city = new City();
		try {
			city = cityRecord.stream().filter(c -> c.getId() == givenId).findAny().get();
		} catch (NoSuchElementException ex) {
			throw new IdNotFoundException(givenId + " is not a valid id");
		}
		logger.info("getCityById method executed successfully");
		return city;
	}

	@Override
	public List<City> getCityByCountryCode(List<City> cityRecord, String givenCountryCode)
			throws CountryCodeNotFoundException {
		logger.info("getCityByCountryCode method started...");
		List<City> cityList = cityRecord.stream().filter(city -> city.getCountryCode().equals(givenCountryCode))
				.collect(Collectors.toList());
		if (cityList.size() == 0) {
			throw new CountryCodeNotFoundException(givenCountryCode + " is not a valid country code ");
		}
		logger.info("getCityByCountryCode method executed successfully");
		return cityList;
	}

}
