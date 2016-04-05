package controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import entity.Client;
import service.ClientService;

@Controller
@RequestMapping(value = "/pages")
public class GetInfoAboutClientsVisas {
	
	@Autowired
	private ClientService clientService;

	@RequestMapping(value = "/clientVisasInfo", method=RequestMethod.GET)
	public String displayClientInfo(@RequestParam("clientId") Integer clientId, Map<String, Object> map){
		map.put("countriesVisited", clientService.findAllCountriesClientVisited(clientId));
		map.put("countCountries", clientService.countVisas(clientId));
		return "countriesClientVisited";
	}

}
