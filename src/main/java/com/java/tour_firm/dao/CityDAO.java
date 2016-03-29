package com.java.tour_firm.dao;

import java.util.List;

import javax.persistence.Query;

import com.java.tour_firm.entity.City;
import com.java.tour_firm.entity.Hotel;

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
