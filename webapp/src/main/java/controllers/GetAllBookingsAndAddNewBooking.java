package controllers;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import entity.Booking;
import service.BookingService;
import service.CityService;
import service.CountryService;
import service.HotelService;

@Controller
public class GetAllBookingsAndAddNewBooking {
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private HotelService hotelService;

	@RequestMapping(value = "/bookings", method=RequestMethod.GET)
	public String displayBookingInfo(Map<String, Object> map){
		map.put("booking", new Booking());
		map.put("bookingList", bookingService.getAllBookings());
		map.put("countriesList", countryService.getAllCountries());
		map.put("citiesList", cityService.getAllCities());
		map.put("hotelList", hotelService.getAllHotels());
		return "bookings";
	}
	
	@RequestMapping(value = "/addBooking", method=RequestMethod.POST)
	public String addBooking(@RequestParam("dateFrom") String dateFrom,
			@RequestParam("dateTo") String dateTo,
			@RequestParam("countryId") Integer countryid,
			@RequestParam("cityId") Integer cityId,
			@RequestParam("hotelId") Integer hotelId,
			@RequestParam("roomQuantity") Integer roomQuantity,
			@RequestParam("clientId") Integer clientId) {
		
		String df = dateFrom;
		String dt = dateTo;
		Integer i = countryid;
		int v = 0;

	return "redirect:bookings";
	}
}

