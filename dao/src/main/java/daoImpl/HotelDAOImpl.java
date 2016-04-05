package daoImpl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import dao.HotelDAO;

import entity.Hotel;

@Repository
public class HotelDAOImpl extends ElementDAOImpl<Hotel, Integer> implements HotelDAO {

	public HotelDAOImpl() {
		super(Hotel.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Integer> findAllRoomsInHotelsByCityId(Integer cityId) {
          Query findAllRooms = getEntityManager().createNamedQuery("findAllRoomsInHotelsByCityId");
          findAllRooms.setParameter("cityId", cityId);
          List<Integer> resultList = findAllRooms.getResultList();
          return resultList;
    }
	
	@SuppressWarnings("unchecked")
	public List<Object[]> findAvgRoomsBookingAndCountClientsForHotel(Integer hotelId) {
        Query findRoomsBooking = getEntityManager().createNamedQuery("findAvgRoomsBookingAndCountClientsForHotel");
        findRoomsBooking.setParameter("hotelId", hotelId);
        List<Object[]> resultList = findRoomsBooking.getResultList();
        return resultList;
    }

	@SuppressWarnings("unchecked")
	public List<Integer> getHotelRoomQuantity(Integer hotelId) {
		Query getRoomQuantity = getEntityManager().createNamedQuery("getHotelRoomQuantity");
		getRoomQuantity.setParameter("hotelId", hotelId);
        List<Integer> resultList = getRoomQuantity.getResultList();
        return resultList;
	}
}
