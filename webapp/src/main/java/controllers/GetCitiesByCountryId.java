package controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.CityService;

@Controller
public class GetCitiesByCountryId {
	
	@Autowired
	private CityService cityService;
	
	@RequestMapping(value = "/getCitiesByCountryId", method = RequestMethod.GET)
	public Map<String, Object> displayBookingInfo(Map<String, Object> map, 
			@RequestParam("countryId") Integer countryId) {
		map.put("citiesList", cityService.getCityByCountryId(countryId));
		return map;
	}
}
