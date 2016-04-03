package dao.impl;

import java.util.List;

import javax.persistence.Query;

import dao.HotelDAO;

import entity.Hotel;

public class HotelDAOImpl extends ElementDAOImpl<Hotel, Long> implements HotelDAO {

	public HotelDAOImpl() {
		super(Hotel.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Integer> findAllRoomsInHotelsByCityId(Long cityId) {
          Query findAllRooms = getEntityManager().createNamedQuery("findAllRoomsInHotelsByCityId");
          findAllRooms.setParameter("cityId", cityId);
          List<Integer> resultList = findAllRooms.getResultList();
          return resultList;
    }
	
	@SuppressWarnings("unchecked")
	public List<Object[]> findAvgRoomsBookingAndCountClientsForHotel(Long hotelId) {
        Query findRoomsBooking = getEntityManager().createNamedQuery("findAvgRoomsBookingAndCountClientsForHotel");
        findRoomsBooking.setParameter("hotelId", hotelId);
        List<Object[]> resultList = findRoomsBooking.getResultList();
        return resultList;
    }

	@SuppressWarnings("unchecked")
	public List<Integer> getHotelRoomQuantity(Long hotId) {
		Query getRoomQuantity = getEntityManager().createNamedQuery("getHotelRoomQuantity");
		getRoomQuantity.setParameter("hotId", hotId);
        List<Integer> resultList = getRoomQuantity.getResultList();
        return resultList;
	}
}
