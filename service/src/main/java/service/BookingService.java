package service;

import java.util.Date;
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
    public Booking getBookingById(Integer bookingId) {
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
    public List<Integer> findFreeAllHotels(Integer cityId) {
        return bookingDao.findAllBookedRoomsInHotelsByCityId(cityId);
    }
    
    @Transactional
    public List<Integer> findAllVisas(Integer countryId) {
        return bookingDao.findAllGivenVisasInOneCountry(countryId);
    }
    
    @Transactional
    public List<Integer> countBookedRooms(Date dateF, Date dateT, Integer hotId) {
    	return bookingDao.countBookedRooms(dateF, dateT, hotId);
    }
    
    @Transactional
    public List<Booking> getBookingsOfPeriod(Date dateF, Date dateT) {
    	return bookingDao.getBookingsOfPeriod(dateF, dateT);
    }
}
