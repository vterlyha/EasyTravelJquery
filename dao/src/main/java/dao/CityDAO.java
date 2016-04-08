package dao;

import java.util.List;

import entity.City;

public interface CityDAO extends ElementDAO<City, Integer> {

	List<String> findAllHotelsByCityName(String cityName);

	List<City> getCityByCountryId(Integer countryId);

	City getCityByName(String cityName);
}
