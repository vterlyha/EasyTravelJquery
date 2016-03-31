package dao;

import java.util.List;

import entity.Hotel;

public interface HotelDAO extends ElementDAO<Hotel, Long> {
    List<Integer> findAllRoomsInHotelsByCityId(Long cityId);
    List<Object[]> findAvgRoomsBookingAndCountClientsForHotel(Long hotelId);
}
