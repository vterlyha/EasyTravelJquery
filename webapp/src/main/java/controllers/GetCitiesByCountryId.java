package controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.CityService;

import entity.City;

@Controller
public class GetCitiesByCountryId {
	
	@Autowired
	private CityService cityService;
	
	@RequestMapping(value = "/cities", method = RequestMethod.GET)
	public Map<String, Object> getCitiesByCountryId(@RequestParam("countryId") Integer countryId, 
							Map<String, Object> map) {
		List <City> cityList = cityService.getCityByCountryId(countryId);
		map.put("cityList", cityList);
		return map;
	}
}
