package dao;

import java.util.List;

import entity.Booking;

public interface BookingDAO extends ElementDAO<Booking, Long> {
    
    List<Integer> findAllBookedRoomsInHotelsByCityId(Long cityId);
    List<Integer> findAllGivenVisasInOneCountry(Long countryId); 
}
