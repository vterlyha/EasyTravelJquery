package implementation;

import java.util.List;

import javax.persistence.Query;
import dao.HotelDAO;

import entity.Hotel;

public class HotelDAOImpl extends ElementDAOImpl<Hotel, Long> implements HotelDAO {

	public HotelDAOImpl() {
		super(Hotel.class);
	}
	
//	public boolean checkIfHotelIsAvailable(
//			Integer hotelId, Integer roomCategoryId, Date dateFrom, Date dateTo) {
//		
//		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("EasyTourJPA");
//		EntityManager eManager = emFactory.createEntityManager();
//		EntityTransaction eTran = null;
//		try {
//			eTran = eManager.getTransaction();
//			eTran.begin();
//			
//			int bookingsCount;
//			Query countBookingsQuery = eManager.createQuery(
//					"select SUM(roomQuantity) "
//					+ "from Booking booking "
//					+ "join booking.roomCategory rCat "
//					+ "join booking.hotel hot "
//					+ "where bookin.dateFrom >= :dateF and "
//					+ "booking.dateTo <= :dateT and "
//					+ "hot.id = :hotId "
//					+ "rCat.id = :rCatId", Integer.class
//					);
//			countBookingsQuery.setParameter("dateF", dateFrom);
//			countBookingsQuery.setParameter("dateT", dateTo);
//			countBookingsQuery.setParameter("hotId", hotelId);
//			countBookingsQuery.setParameter("rCatId", roomCategoryId);
//			bookingsCount = countBookingsQuery.getFirstResult();
//			
//			int reserved;
//			Query getReservedRooms = eManager.createQuery(""
//					+ "select rCatHot.quantity "
//					+ "from RoomCategoryHotel rCatHot "
//					+ "join rCatHot.roomCategory rCat "
//					+ "join rCatHot.hotel hot "
//					+ "where hot.id = :hotId "
//					+ "rCat.id = :rCatId");
//			getReservedRooms.setParameter("hotId", hotelId);
//			getReservedRooms.setParameter("rCatId", roomCategoryId);
//			reserved = getReservedRooms.getFirstResult();
//			
//			eTran.commit();
//			return (reserved - bookingsCount) > 0;
//		}
//		catch(RuntimeException e) {
//			if (eTran.isActive())
//				eTran.rollback();
//			throw e;
//		}
		
//	}
	
	@SuppressWarnings("unchecked")
	public List<Integer> findAllRoomsInHotelsByCityId(Long cityId) {
          Query q = getEntityManager().createNamedQuery("findAllRoomsInHotelsByCityId");
          q.setParameter("cityId", cityId);
          List<Integer> resultList = q.getResultList();
          return resultList;
    }
	
	@SuppressWarnings("unchecked")
	public List<Object[]> findAvgRoomsBookingAndCountClientsForHotel(Long hotelId) {
          Query q = getEntityManager().createNamedQuery("findAvgRoomsBookingAndCountClientsForHotel");
          q.setParameter("hotelId", hotelId);
          List<Object[]> resultList = q.getResultList();

        return resultList;
    }
}
