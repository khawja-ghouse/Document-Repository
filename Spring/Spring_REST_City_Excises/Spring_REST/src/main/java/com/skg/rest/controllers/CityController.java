package com.skg.rest.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skg.rest.entity.City;
import com.skg.rest.exception.CountryCodeNotFoundException;
import com.skg.rest.exception.IdNotFoundException;
import com.skg.rest.exception.InvalidFileNameException;
import com.skg.rest.services.impl.CityServicesImpl;
import com.skg.rest.util.CityUtil;

@RestController
@RequestMapping("/City")
public class CityController {

	Logger logger = LoggerFactory.getLogger(CityController.class);
	List<City> cityList = null;

	public CityController() {
		try {
			logger.debug("Inside City Controller Constructor");
			cityList = CityUtil.getAllCityList();
		} catch (InvalidFileNameException e) {
			e.printStackTrace();
		}
	}

	@Autowired
	public CityServicesImpl cityServices;

	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<City>> getAllCity() {
		logger.debug("Inside getAllCity controller " + cityList);
		return ResponseEntity.ok(cityList);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/maxPopulation", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public City getMaxPopulation() {
		return cityServices.getMaxPopulatedCity(cityList);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/minPopulation", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public City getMinPopulation() {
		return cityServices.getMinPopulatedCity(cityList);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/getCityById", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public City getCityById(@RequestHeader("cityId") int cityId) throws IdNotFoundException {
		return cityServices.getCityById(cityList, cityId);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/getCityByCountryCode", produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<City> getCityByCountryCode(@RequestHeader("code") String code) throws CountryCodeNotFoundException {
		return cityServices.getCityByCountryCode(cityList, code);
	}

}
