package controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entity.Booking;
import service.BookingService;
import service.CityService;
import service.ClientService;
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
	
	@Autowired
	private ClientService clientService;

	@RequestMapping(value = "/bookings", method=RequestMethod.GET)
	public String displayBookingInfo(Map<String, Object> map){
		map.put("booking", new Booking());
		map.put("bookingList", bookingService.getAllBookings());
		map.put("countriesList", countryService.getAllCountries());
		map.put("citiesList", cityService.getAllCities());
		map.put("hotelList", hotelService.getAllHotels());
		map.put("clientList", clientService.getAllClients());
		return "bookings";
	}
	
	@RequestMapping(value = "/addBooking", method=RequestMethod.POST)
	public String addClient(@ModelAttribute("booking") Booking booking,
	BindingResult result) {
		Booking booking2 = booking;
		int a = 0;
		int b = 0;
	bookingService.addBooking(booking);
	return "redirect:bookings";
	}
}

