package dao;

import java.util.List;

import entity.City;

public interface CityDAO extends ElementDAO<City, Long> {
    List<String> findAllHotelsByCityName(String cityName);
    List<String> getCityByCountryId(Long countryId);
}
