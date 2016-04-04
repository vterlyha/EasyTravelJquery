package daoImpl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import dao.HotelDAO;

import entity.Hotel;

@Repository
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
