package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/pages")
public class ClientInfoController {

	@RequestMapping(value = "/clientInfo", method=RequestMethod.GET)
	public String displayHome(){
		System.out.println("in client info");
		return "clientInfo";
	}
}
