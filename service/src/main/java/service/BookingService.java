package service;

import java.util.List;

import dao.DAOFactory;
import entity.Booking;

public class BookingService {
	
    public void addBooking(Booking booking) {
        DAOFactory.getInstance().getBookingDAO().addElement(booking);
    }
    
    public void updateBooking(Booking booking) {
        DAOFactory.getInstance().getBookingDAO().updateElement(booking);
    }
    
    public Booking getBookingById(Integer bookingId) {
        return DAOFactory.getInstance().getBookingDAO()
                .getElementByID(bookingId);
    }
    
    public List<Booking> getAllBookings() {
        return DAOFactory.getInstance().getBookingDAO()
                .getAllElements();
    }
    
    public void deleteBooking(Booking booking) {
        DAOFactory.getInstance().getBookingDAO().deleteElement(booking);
    }
    
    public List<Integer> findFreeAllHotels(Integer cityId) {
        return DAOFactory.getInstance().getBookingDAO().findAllBookedRoomsInHotelsByCityId(cityId);
    }
    
    public List<Integer> findAllVisas(Integer countryId) {
        return DAOFactory.getInstance().getBookingDAO().findAllGivenVisasInOneCountry(countryId);
    }
}
