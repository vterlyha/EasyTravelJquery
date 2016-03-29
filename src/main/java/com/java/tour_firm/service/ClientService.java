package com.java.tour_firm.service;

import java.util.List;

import com.java.tour_firm.dao.DAOFactory;
import com.java.tour_firm.entity.Client;

public class ClientService {
	
	public ClientService(){
		super();
	}
    
    public void addClient(Client client) {
        DAOFactory.getInstance().getClientDAO().addElement(client);
    }
    
    public void updateClient(Client client) {
        DAOFactory.getInstance().getClientDAO().updateElement(client);
    }
    
    public Client getClientById(Integer clientId) {
        return DAOFactory.getInstance().getClientDAO()
                .getElementByID(clientId);
    }
    
    public List<Client> getAllClients() {
        return DAOFactory.getInstance().getClientDAO()
                .getAllElements();
    }
    
    public void deleteClient(Client client) {
        DAOFactory.getInstance().getClientDAO().deleteElement(client);
    }

}
