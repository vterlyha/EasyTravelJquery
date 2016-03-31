package service;

import java.util.List;

import dao.DAOFactory;
import entity.Country;

public class CountryService {
	
	public void addCountry(Country c) {
		DAOFactory.getInstance().getCountryDAO().addElement(c);
	}
	
	public void updateCountry(Country c) {
		DAOFactory.getInstance().getCountryDAO().updateElement(c);
	}
	
	public Country getCountryById(Integer countryId) {
		return DAOFactory.getInstance().getCountryDAO()
				.getElementByID(countryId);
	}
	
	public List<Country> getAllCountries() {
		return DAOFactory.getInstance().getCountryDAO()
				.getAllElements();
	}
	
	public void deleteCountry(Country c) {
		DAOFactory.getInstance().getCountryDAO().deleteElement(c);
	}

}
