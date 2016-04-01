package dao;

import java.util.List;
import java.util.Date;

import entity.Booking;

public interface BookingDAO extends ElementDAO<Booking, Long> {
    
    List<Integer> findAllBookedRoomsInHotelsByCityId(Long cityId);
    List<Integer> findAllGivenVisasInOneCountry(Long countryId); 
    List<Integer> countBookedRooms(Date dateF, Date dateT, Long hotId);
    List<Booking> getBookingsOfPeriod(Date dateF, Date dateT);
}
