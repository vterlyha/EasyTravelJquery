package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import entity.City;
import entity.Country;
import entity.Hotel;
import service.CityService;
import service.CountryService;
import service.HotelService;

@Controller
public class HotelInfoController {
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private CityService cityService;
	
	@Autowired
	private HotelService hotelService;
	
	@RequestMapping(value = "/hotelInfo", method=RequestMethod.GET)
	public String displayHotelInfo(Model model){
		
		List<Hotel> hotels = this.hotelService.getAllHotels();
		List<Country> countries = this.countryService.getAllCountries();
		List<City> cities = this.cityService.getAllCities();
		model.addAttribute("hotels", hotels);
		model.addAttribute("countries", countries);
		model.addAttribute("cities", cities);
		return "hotelInfo";
	}
	
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
		return "hotelInfo";
	}
	
	@RequestMapping(value = "/insertCountry", method = RequestMethod.POST)
	public String insertCountry(Model model, 
			@RequestParam("countryName") String countryName,
			@RequestParam("visaRequired") Boolean visaRequired) {

		countryService.addCountry(new Country(0,countryName,visaRequired));
		return "hotelInfo";
	}
	
	@RequestMapping(value = "/insertCity", method = RequestMethod.POST)
	public String insertCity(Model model,
			@RequestParam("cityName")String cityName,
			@RequestParam("countryValue")String countryValue) {
		
		Country countryToNewCity = new Country();
		for (Country c: countryService.getAllCountries()){
			if (c.getName().equals(countryValue))
				countryToNewCity = c;
		}
		City newCity = new City(0,cityName,countryToNewCity);
		
		cityService.addCity(newCity);
		return "hotelInfo";
	}
}
