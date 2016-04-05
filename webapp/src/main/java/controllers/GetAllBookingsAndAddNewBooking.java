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

@Controller
@RequestMapping(value = "/pages")
public class GetAllBookingsAndAddNewBooking {
	
	@Autowired
	private BookingService bookingService;

	@RequestMapping(value = "/bookings", method=RequestMethod.GET)
	public String displayBookingInfo(Map<String, Object> map){
		map.put("booking", new Booking());
		map.put("bookingList", bookingService.getAllBookings());
		return "bookings";
	}
	
//	@RequestMapping(value = "/add", method=RequestMethod.POST)
//	public String addBooking(@ModelAttribute("client") Booking booking,
//	BindingResult result) {
//		bookingService.addBooking(booking);
//	return "redirect:bookings";
//	}
}

