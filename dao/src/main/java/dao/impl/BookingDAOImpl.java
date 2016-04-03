package dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import dao.BookingDAO;
import entity.Booking;

public class BookingDAOImpl extends ElementDAOImpl<Booking, Long> implements BookingDAO {

    
    public BookingDAOImpl() {
        super(Booking.class);
    }
    
    @SuppressWarnings("unchecked")
    public List<Integer> findAllBookedRoomsInHotelsByCityId(Long cityId) {
          Query findBookedRoomsQuery = getEntityManager().createNamedQuery("findAllBookedRoomsInHotelsByCityId");
          findBookedRoomsQuery.setParameter("cityId", cityId);
          List<Integer> resultList = findBookedRoomsQuery.getResultList();
        return resultList;
    }
    
    @SuppressWarnings("unchecked")
    public List<Integer> findAllGivenVisasInOneCountry(Long countryId) {
          Query findAllVisasQuery = getEntityManager().createNamedQuery("findAllGivenVisasInOneCountry");
          findAllVisasQuery.setParameter("countryId", countryId);
          List<Integer> resultList = findAllVisasQuery.getResultList();
          return resultList;
    }

    @SuppressWarnings("unchecked")
	public List<Integer> countBookedRooms(Date dateF, Date dateT, Long hotId) {
		Query countRooms = getEntityManager().createNamedQuery("countBookedRooms");
		countRooms.setParameter("dateF", dateF);
		countRooms.setParameter("dateT", dateT);
		countRooms.setParameter("hotId", hotId);
		List<Integer> resultList = countRooms.getResultList();
		return resultList;
	}

    @SuppressWarnings("unchecked")
	public List<Booking> getBookingsOfPeriod(Date dateF, Date dateT) {
		Query getBookings = getEntityManager().createNamedQuery("getBookingsOfPeriod");
		getBookings.setParameter("dateF", dateF);
		getBookings.setParameter("dateT", dateT);
		List<Booking> resultList = getBookings.getResultList();
		return resultList;
	}

}
