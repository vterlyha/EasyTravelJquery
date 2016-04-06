package controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import dto.HotelsTableDto;
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
		
		List<HotelsTableDto> generalHotelsInfo = new ArrayList<HotelsTableDto>();
		List<Object[]> hotelInfoStates = hotelService.findInfoAboutHotels(1);
		for (int i = 0; i< hotels.size(); i++) {
				generalHotelsInfo.add(
					new HotelsTableDto(hotels.get(i),
							"-","-"));
		}
		for (int i = 0; i < hotelInfoStates.size(); i++) {
			generalHotelsInfo.get(i).setNumOfClients(hotelInfoStates.get(i)[0]);
			generalHotelsInfo.get(i).setAvgStayLength(hotelInfoStates.get(i)[1]);
		}
		model.addAttribute("generalHotels", generalHotelsInfo);
		model.addAttribute("countries", countries);
		model.addAttribute("cities", cities);
		
		return "hotelInfo";
	}
}
