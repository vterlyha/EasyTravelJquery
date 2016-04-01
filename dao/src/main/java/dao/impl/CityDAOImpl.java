package dao.impl;

import java.util.List;

import javax.persistence.Query;

import dao.CityDAO;
import entity.City;

public class CityDAOImpl extends ElementDAOImpl<City, Long> implements CityDAO {

	public CityDAOImpl() {
		super(City.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<String> findAllHotelsByCityName(String cityName) {

          Query findHotels = getEntityManager().createNamedQuery("findAllHotelsByCityName");
          findHotels.setParameter("cityName", cityName);
          List<String> resultList = findHotels.getResultList();
          return resultList;
    }

	@SuppressWarnings("unchecked")
	public List<String> getCityByCountryId(Long countryId) {
		
		Query getCities = getEntityManager().createNamedQuery("getCityByCountryId");
        getCities.setParameter("countryId", countryId);
        List<String> resultList = getCities.getResultList();
        return resultList;
	}
}
