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

	public Integer getHotelRoomQuantity(Integer hotId) {
		Query getRoomQuantity = getEntityManager().createNamedQuery("getHotelRoomQuantity");
		getRoomQuantity.setParameter("hotId", hotId);
		Integer result = (Integer) getRoomQuantity.getSingleResult();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<Hotel> getHotelByCityId(Integer cityId) {
		Query getHotels = getEntityManager().createNamedQuery("getHotelByCityId");
		getHotels.setParameter("cityId", cityId);
        List<Hotel> resultList = getHotels.getResultList();
        return resultList;
	}
}
