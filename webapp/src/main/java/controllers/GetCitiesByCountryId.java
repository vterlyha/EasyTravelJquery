package controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import service.CityService;


@Controller
public class GetCitiesByCountryId {

    @Autowired
    private CityService cityService;

    @ResponseBody
    @RequestMapping(value = "/getCitiesByCountryId", method = RequestMethod.GET,
                    produces = "application/json")
    public Map<String, Object> displayBookingInfo(Map<String, Object> map,
                                                  @RequestParam(value = "countryId", required = false)
                                                  Integer countryId) {
        map.put("citiesList", this.cityService.getCityByCountryId(countryId));
        int a = 0;
        return map;
    }
}
