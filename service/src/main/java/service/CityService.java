package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.CityDAO;
import entity.City;

@Service
public class CityService {

    @Autowired
    private CityDAO cityDao;
    
    public CityService() {
    }
    
    @Transactional
    public void addCity(City city) {
        cityDao.addElement(city);
    }
    
    @Transactional
    public void updateCity(City city) {
        cityDao.updateElement(city);
    }
    
    @Transactional
    public City getCityById(Integer cityId) {
        return cityDao.getElementByID(cityId);
    }
    
    @Transactional
    public List<City> getAllCities() {
        return cityDao.getAllElements();
    }
    
    @Transactional
    public void deleteCity(City city) {
        cityDao.deleteElement(city);
    }
	
    @Transactional
	public List<String> findAllHotels(String cityName) {
        return cityDao.findAllHotelsByCityName(cityName);
    }
    
    @Transactional
    public List<City> getCityByCountryId(Integer countryId) {
    	return cityDao.getCityByCountryId(countryId);
    }
    
    @Transactional
    public City getCityByCityName(String cityName) {
    	return cityDao.getCityByName(cityName);
    }
}
