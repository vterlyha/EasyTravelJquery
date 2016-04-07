package controllers;

import java.sql.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String addClient(Map<String, Object> map, @RequestParam("dateFrom") Date dateFrom,
			@RequestParam("dateTo") Date dateTo, @RequestParam("hotelValue") String hotId) {
		Integer hotelIdInteger = Integer.parseInt(hotId);
		Integer bookedRooms = bookingService.countBookedRooms(dateFrom, dateTo, hotelIdInteger);
		Integer roomQuantity = hotelService.getHotelRoomQuantity(hotelIdInteger);
		map.put("bookedRooms", bookedRooms);
		map.put("hotel", hotelService.getHotelById(hotelIdInteger));
		map.put("roomQuantity", roomQuantity);
		map.put("availableRooms", (roomQuantity - bookedRooms));
		return "freeRooms";
	}
}
