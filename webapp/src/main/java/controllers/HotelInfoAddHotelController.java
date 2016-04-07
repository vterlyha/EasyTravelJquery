package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import entity.City;
import entity.Hotel;
import service.CityService;
import service.HotelService;

@Controller
public class HotelInfoAddHotelController {

	@Autowired
	private CityService cityService;
	
	@Autowired
	private HotelService hotelService;
	
	@RequestMapping(value = "/insertHotel", method = RequestMethod.POST)
	public String insertHotel(Model model,
			@RequestParam("hotelName")String hotelName,
			@RequestParam("hotelRoomQuantity")String hotelRoomQuantity,
			@RequestParam("cityValue") String cityValue) {
		
		City cityToNewHotel = new City();
		for (City c: cityService.getAllCities()){
			if (c.getName().equals(cityValue))
				cityToNewHotel = c;
		}
		Hotel newHotel = new Hotel(0, hotelName, 
				cityToNewHotel, Integer.parseInt(hotelRoomQuantity));
		hotelService.addHotel(newHotel);
		return "redirect:hotelInfo";
	}
}
