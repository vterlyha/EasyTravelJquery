package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/pages")
public class HotelInfoController {

	@RequestMapping(value = "/hotelInfo", method=RequestMethod.GET)
	public String displayHotelInfo(){
		System.out.println("HotelInfoController");
		return "hotelInfo";
	}
}
