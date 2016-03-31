package dao;


import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entity.Hotel;

public class HotelDAO extends ElementDAOImpl<Hotel> {

	public HotelDAO() {
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
	
	public List<Integer> findAllRoomsInHotelsByCityId(Integer cityId) {
        List<Integer> resultList;
        try {
          eManager = emf.createEntityManager();
          Query q = eManager.createNamedQuery("findAllRoomsInHotelsByCityId");
          q.setParameter("cityId", cityId);
          resultList = q.getResultList();
          eManager.close();
          emf.close();
        }
        catch(RuntimeException e) {
            if (eTransaction.isActive())
                eTransaction.rollback();
            throw e;
        }
        return resultList;
    }
	
	public List<Object[]> findAvgRoomsBookingAndCountClientsForHotel(Integer hotelId) {
        List<Object[]> resultList;
//        try {
          eManager = emf.createEntityManager();
          Query q = eManager.createNamedQuery("findAvgRoomsBookingAndCountClientsForHotel");
          q.setParameter("hotelId", hotelId);
          resultList = q.getResultList();
          eManager.close();
          emf.close();
//        }
//        catch(RuntimeException e) {
//            if (eTransaction.isActive())
//                eTransaction.rollback();
//            throw e;
//        }
        return resultList;
    }
}
