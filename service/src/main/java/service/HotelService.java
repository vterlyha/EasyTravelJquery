package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.HotelDAO;
import entity.Hotel;

@Service
public class HotelService {

	@Autowired
	private HotelDAO hotelDao;

	public HotelService() {
	}

	@Transactional
	public void addHotel(Hotel hotel) {
		hotelDao.addElement(hotel);
	}

	@Transactional
	public void updateHotel(Hotel hotel) {
		hotelDao.updateElement(hotel);
	}

	@Transactional
	public Hotel getHotelById(Integer hotelId) {
		return hotelDao.getElementByID(hotelId);
	}

	@Transactional
	public List<Hotel> getAllHotels() {
		return hotelDao.getAllElements();
	}

	@Transactional
	public void deleteHotel(Hotel hotel) {
		hotelDao.deleteElement(hotel);
	}

	@Transactional
	public List<Integer> findAllHotels(Integer cityId) {
		return hotelDao.findAllRoomsInHotelsByCityId(cityId);
	}

	@Transactional
	public List<Object[]> findInfoAboutHotels(Integer hotelId) {
		return hotelDao.findAvgRoomsBookingAndCountClientsForHotel(hotelId);
	}

	@Transactional
	public Integer getHotelRoomQuantity(Integer hotId) {
		return hotelDao.getHotelRoomQuantity(hotId);
	}
}
