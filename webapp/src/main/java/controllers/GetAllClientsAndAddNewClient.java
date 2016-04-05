package controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entity.Client;
import service.ClientService;

@Controller
public class GetAllClientsAndAddNewClient {
	
	@Autowired
	private ClientService clientService;

	@RequestMapping(value = "/clientInfo", method=RequestMethod.GET)
	public String displayClientInfo(Map<String, Object> map){
		map.put("client", new Client());
		map.put("clientList", clientService.getAllClients());
		return "clientInfo";
	}
	
	@RequestMapping(value = "/add", method=RequestMethod.POST)
	public String addClient(@ModelAttribute("client") Client client,
	BindingResult result) {
	clientService.addClient(client);
	return "redirect:clientInfo";
	}
}
