package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.CountryService;

@Controller
@RequestMapping(value="/pages")
public class HotelInfoController {

	@Autowired
	private CountryService countryS;
	
	@RequestMapping(value = "/hotelInfo", method=RequestMethod.GET)
	public String displayHotelInfo(Model model){
		System.out.println("HotelInfoController");
		model.addAttribute("countries", this.countryS.getAllCountries());
		return "hotelInfo";
	}
}
