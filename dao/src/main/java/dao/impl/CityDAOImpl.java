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

          Query q = getEntityManager().createNamedQuery("findAllHotelsByCityName");
          q.setParameter("cityName", cityName);
          List<String> resultList = q.getResultList();

          return resultList;
    }
}
