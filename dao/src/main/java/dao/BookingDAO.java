package dao;

import java.sql.Date;
import java.util.List;

import entity.Booking;

public interface BookingDAO extends ElementDAO<Booking, Integer> {

	List<Integer> findAllBookedRoomsInHotelsByCityId(Integer cityId);

	List<Integer> findAllGivenVisasInOneCountry(Integer countryId);

	Integer countBookedRooms(Date dateF, Date dateT, Integer hotelId);

	List<Booking> getBookingsOfPeriod(Date dateF, Date dateT);
}
