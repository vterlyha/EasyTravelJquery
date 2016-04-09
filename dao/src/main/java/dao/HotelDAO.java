package dao;

import java.util.List;

import entity.Hotel;

public interface HotelDAO extends ElementDAO<Hotel, Integer> {
	List<Integer> findAllRoomsInHotelsByCityId(Integer cityId);

	List<Object[]> findAvgRoomsBookingAndCountClientsForHotel(Integer hotelId);

	Integer getHotelRoomQuantity(Integer hotelId);
	
	List<Hotel> getHotelByCityId(Integer cityId);
}
