package controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import service.HotelService;


@Controller
public class GetHotelsByCityId {

    @Autowired
    private HotelService hotelService;

    @ResponseBody
    @RequestMapping(value = "/getHotelsByCityId", method = RequestMethod.GET,
                    produces = "application/json")
    public Map<String, Object> displayHotelsInfo(Map<String, Object> map,
                                                  @RequestParam(value = "cityId", required = false)
                                                  Integer cityId) {
        map.put("citiesList", this.hotelService.getHotelByCityId(cityId));
        return map;
    }
}
