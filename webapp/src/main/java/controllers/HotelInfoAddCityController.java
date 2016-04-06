package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import entity.City;
import entity.Country;
import service.CityService;
import service.CountryService;

@Controller
public class HotelInfoAddCityController {

	@Autowired
	private CountryService countryService;
	
	@Autowired
	private CityService cityService;
	
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
