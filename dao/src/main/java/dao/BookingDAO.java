package dao;

import java.util.List;
import java.util.Date;

import entity.Booking;

public interface BookingDAO extends ElementDAO<Booking, Integer> {
    
    List<Integer> findAllBookedRoomsInHotelsByCityId(Integer cityId);
    List<Integer> findAllGivenVisasInOneCountry(Integer countryId); 
    List<Integer> countBookedRooms(Date dateF, Date dateT, Integer hotelId);
    List<Booking> getBookingsOfPeriod(Date dateF, Date dateT);
}
