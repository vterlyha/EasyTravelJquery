package controllers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
		
		List<Country> countries = this.countryService.getAllCountries();
		model.addAttribute("countries", countries);
		model.addAttribute("currentCountry", countries.get(0));
		return "hotelInfo";
	}
	
	@RequestMapping(value = "/selectCity", method = RequestMethod.GET)
	public String displayCities(@RequestParam("countryValue") String countryValue, 
								@RequestParam("cityValue") String cityValue,
								Model model) {
		
		List<City> cities = new ArrayList<City>();
		List<Country> countries = this.countryService.getAllCountries();
		List<Hotel> hotels = this.hotelService.getAllHotels();
		
		for (City c: this.cityService.getAllCities()) {
			if (c.getCountry().getName().equals(countryValue)) {
				cities.add(c);
			}
		}
		for (Hotel h: this.hotelService.getAllHotels()) {
			if (h.getCity().getName().equals(cityValue)) {
				hotels.add(h);
			}
		}
		model.addAttribute("cities", cities);
		model.addAttribute("hotels", hotels);
		model.addAttribute("countries", countries);
	    return "hotelInfo";
	}
}
