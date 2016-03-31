package implementation;


import java.util.List;

import javax.persistence.Query;

import dao.BookingDAO;
import entity.Booking;

public class BookingDAOImpl extends ElementDAOImpl<Booking, Long> implements BookingDAO {

    
    public BookingDAOImpl() {
        super(Booking.class);
    }
    
    @SuppressWarnings("unchecked")
    public List<Integer> findAllBookedRoomsInHotelsByCityId(Integer cityId) {
          Query q = getEntityManager().createNamedQuery("findAllBookedRoomsInHotelsByCityId");
          q.setParameter("cityId", cityId);
          List<Integer> resultList = q.getResultList();
        return resultList;
    }
    
    @SuppressWarnings("unchecked")
    public List<Integer> findAllGivenVisasInOneCountry(Integer countryId) {
          Query q = getEntityManager().createNamedQuery("findAllGivenVisasInOneCountry");
          q.setParameter("countryId", countryId);
          List<Integer> resultList = q.getResultList();
          return resultList;
    }

}
