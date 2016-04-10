package controllers;

import java.sql.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import entity.Booking;
import entity.City;
import entity.Client;
import entity.Country;
import entity.Hotel;
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

	@RequestMapping(value = "/bookingsAngular", method = RequestMethod.GET)
	public String displayBookingInfo(Map<String, Object> map) {
		map.put("bookingList", bookingService.getAllBookings());
		map.put("countriesList", countryService.getAllCountries());
		map.put("hotelList", hotelService.getAllHotels());
		map.put("clientList", clientService.getAllClients());
		return "bookingsAngular";
	}

	@RequestMapping(value = "/addBooking", method = RequestMethod.POST)
	public String addClient(@RequestParam("dateFrom") Date dateFrom, @RequestParam("dateTo") Date dateTo,
			@RequestParam("countryId") Integer countryId, @RequestParam("cityId") Integer cityId,
			@RequestParam("hotelId") Integer hotelId, @RequestParam("roomQuantity") Integer roomQuantity,
			@RequestParam("clientId") Integer clientId) {
		Country country = countryService.getCountryById(countryId);
		City city = cityService.getCityById(cityId);
		Hotel hotel = hotelService.getHotelById(hotelId);
		Client client = clientService.getClientById(clientId);
		Booking booking = new Booking(0, dateFrom, dateTo, country, city, hotel, client, roomQuantity);
		bookingService.addBooking(booking);
		return "redirect:bookingsAngular";
	}
}
