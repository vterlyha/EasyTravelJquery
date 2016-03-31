package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.BookingDAO;
import entity.Booking;

@Service
public class BookingService {
	
    @Autowired
    private BookingDAO bookingDao;
    
    public BookingService() {
    }
    
    @Transactional
    public void addBooking(Booking booking) {
        bookingDao.addElement(booking);
    }
    
    @Transactional
    public void updateBooking(Booking booking) {
        bookingDao.updateElement(booking);
    }
    
    @Transactional
    public Booking getBookingById(Long bookingId) {
        return bookingDao.getElementByID(bookingId);
    }
    
    @Transactional
    public List<Booking> getAllBookings() {
        return bookingDao.getAllElements();
    }
    
    @Transactional
    public void deleteBooking(Booking booking) {
        bookingDao.deleteElement(booking);
    }
    
    @Transactional
    public List<Integer> findFreeAllHotels(Long cityId) {
        return bookingDao.findAllBookedRoomsInHotelsByCityId(cityId);
    }
    
    @Transactional
    public List<Integer> findAllVisas(Long countryId) {
        return bookingDao.findAllGivenVisasInOneCountry(countryId);
    }
}
