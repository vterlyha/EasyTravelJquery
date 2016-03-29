package com.java.tour_firm.service;

import java.util.List;

import com.java.tour_firm.dao.DAOFactory;
import com.java.tour_firm.entity.Hotel;

public class HotelService {

	public void addHotel(Hotel c) {
		DAOFactory.getInstance().getHotelDAO().addElement(c);
	}
	
	public void updateHotel(Hotel c) {
		DAOFactory.getInstance().getHotelDAO().updateElement(c);
	}
	
	public Hotel getHotelById(Integer hotelId) {
		return DAOFactory.getInstance().getHotelDAO()
				.getElementByID(hotelId);
	}
	
	public List<Hotel> getAllHotels() {
		return DAOFactory.getInstance().getHotelDAO()
				.getAllElements();
	}
	
	public void deleteHotel(Hotel c) {
		DAOFactory.getInstance().getHotelDAO().deleteElement(c);
	}
}
