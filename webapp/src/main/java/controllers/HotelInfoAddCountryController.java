package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import entity.Country;
import service.CountryService;

@Controller
public class HotelInfoAddCountryController {
	
	@Autowired
	private CountryService countryService;
	
	@RequestMapping(value = "/insertCountry", method = RequestMethod.POST)
	public String insertCountry(Model model, 
			@RequestParam("countryName") String countryName,
			@RequestParam("visaRequired") Boolean visaRequired) {

		countryService.addCountry(new Country(0,countryName,visaRequired));
		return "redirect:hotelInfo";
	}
}
