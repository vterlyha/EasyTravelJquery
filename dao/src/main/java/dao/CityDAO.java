package dao;
import java.util.List;

import javax.persistence.Query;

import entity.City;

public class CityDAO extends ElementDAOImpl<City> {

	public CityDAO() {
		super(City.class);
	}
	
	public List<String> findAllHotelsByCityName(String cityName) {
        List<String> resultList;
        try {
          eManager = emf.createEntityManager();
          Query q = eManager.createNamedQuery("findAllHotelsByCityName");
          q.setParameter("cityName", cityName);
          resultList = q.getResultList();
          eManager.close();
          emf.close();
        }
        catch(RuntimeException e) {
            if (eTransaction.isActive())
                eTransaction.rollback();
            throw e;
        }
        return resultList;
    }
}
