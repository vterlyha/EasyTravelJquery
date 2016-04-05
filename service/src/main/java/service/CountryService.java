package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.CountryDAO;
import entity.Country;

@Service
public class CountryService {
	
    @Autowired
    private CountryDAO countryDao;
    
    public CountryService() {
    }
    
    @Transactional
    public void addCountry(Country country) {
        countryDao.addElement(country);
    }
    
    @Transactional
    public void updateCountry(Country country) {
        countryDao.updateElement(country);
    }
    
    @Transactional
    public Country getCountryById(Integer countryId) {
        return countryDao.getElementByID(countryId);
    }
    
    @Transactional
    public List<Country> getAllCountries() {
        return countryDao.getAllElements();
    }
    
    @Transactional
    public void deleteCountry(Country country) {
        countryDao.deleteElement(country);
    }

}
