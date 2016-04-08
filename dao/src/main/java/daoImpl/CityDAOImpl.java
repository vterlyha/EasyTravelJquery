package daoImpl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import dao.CityDAO;
import entity.City;

@Repository
public class CityDAOImpl extends ElementDAOImpl<City, Integer> implements CityDAO {

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
	public List<City> getCityByCountryId(Integer countryId) {
		
		Query getCities = getEntityManager().createNamedQuery("getCityByCountryId");
        getCities.setParameter("countryId", countryId);
        List<City> resultList = getCities.getResultList();
        return resultList;
	}
	
	public City getCityByName(String cityName) {
		Query findCity = getEntityManager().createNamedQuery("City.findByName");
		findCity.setParameter("cityName", cityName);
        City city = (City)findCity.getSingleResult();
        return city;
	};
}
