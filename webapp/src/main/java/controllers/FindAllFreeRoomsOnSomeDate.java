package controllers;

import java.sql.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import entity.Hotel;
import service.BookingService;
import service.HotelService;

@Controller
public class FindAllFreeRoomsOnSomeDate {

	@Autowired
	private HotelService hotelService;

	@Autowired
	private BookingService bookingService;

	@RequestMapping(value = "/freeRoomsStatistics", method = RequestMethod.GET)
	public String displayClientInfo(Map<String, Object> map) {
		map.put("hotelList", hotelService.getAllHotels());
		return "findFreeRooms";
	}

	@RequestMapping(value = "/findFreeRooms", method = RequestMethod.GET)
	public String addClient(@RequestParam("dateFrom") Date dateFrom, @RequestParam("dateTo") Date dateTo,
			@RequestParam("hotelId") String hotelId) {
		Integer hotelIdInteger = Integer.parseInt(hotelId);
		Integer hotelCount = bookingService.countBookedRooms(dateFrom, dateTo, hotelIdInteger);
		Hotel hotel = hotelService.getHotelById(hotelIdInteger);
		return "redirect:clientInfo";
	}
}
