package com.java.tour_firm.service;

import java.util.List;

import com.java.tour_firm.dao.DAOFactory;
import com.java.tour_firm.entity.City;

public class CityService {

	public void addCity(City c) {
		DAOFactory.getInstance().getCityDAO().addElement(c);
	}
	
	public void updateCity(City c) {
		DAOFactory.getInstance().getCityDAO().updateElement(c);
	}
	
	public City getCityById(Integer cityId) {
		return DAOFactory.getInstance().getCityDAO()
				.getElementByID(cityId);
	}
	
	public List<City> getAllCities() {
		return DAOFactory.getInstance().getCityDAO()
				.getAllElements();
	}
	
	public void deleteCity(City c) {
		DAOFactory.getInstance().getCityDAO().deleteElement(c);
	}
}
