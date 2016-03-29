package com.java.tour_firm.dao;

import java.util.List;

import javax.persistence.Query;

import com.java.tour_firm.entity.Booking;

public class BookingDAO extends ElementDAOImpl<Booking> {
    
    public BookingDAO() {
        super(Booking.class);
    }
    
    public List<Integer> findAllBookedRoomsInHotelsByCityId(Integer cityId) {
        List<Integer> resultList;
        try {
          eManager = emf.createEntityManager();
          Query q = eManager.createNamedQuery("findAllBookedRoomsInHotelsByCityId");
          q.setParameter("cityId", cityId);
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
    
    public List<Integer> findAllGivenVisasInOneCountry(Integer countryId) {
        List<Integer> resultList;
        try {
          eManager = emf.createEntityManager();
          Query q = eManager.createNamedQuery("findAllGivenVisasInOneCountry");
          q.setParameter("countryId", countryId);
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
