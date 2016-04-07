package daoImpl;

import java.sql.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import dao.BookingDAO;
import entity.Booking;

@Repository
public class BookingDAOImpl extends ElementDAOImpl<Booking, Integer> implements BookingDAO {

	public BookingDAOImpl() {
		super(Booking.class);
	}

	@SuppressWarnings("unchecked")
	public List<Integer> findAllBookedRoomsInHotelsByCityId(Integer cityId) {
		Query findBookedRoomsQuery = getEntityManager().createNamedQuery("findAllBookedRoomsInHotelsByCityId");
		findBookedRoomsQuery.setParameter("cityId", cityId);
		List<Integer> resultList = findBookedRoomsQuery.getResultList();
		return resultList;
	}

	@SuppressWarnings("unchecked")
	public List<Integer> findAllGivenVisasInOneCountry(Integer countryId) {
		Query findAllVisasQuery = getEntityManager().createNamedQuery("findAllGivenVisasInOneCountry");
		findAllVisasQuery.setParameter("countryId", countryId);
		List<Integer> resultList = findAllVisasQuery.getResultList();
		return resultList;
	}

	public Integer countBookedRooms(Date dateF, Date dateT, Integer hotelId) {
		Query countRooms = getEntityManager().createNamedQuery("countBookedRooms");
		countRooms.setParameter("dateF", dateF);
		countRooms.setParameter("dateT", dateT);
		countRooms.setParameter("hotelId", hotelId);
		Long num = (Long) countRooms.getSingleResult();
		Integer result = num.intValue();
		return result;
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
