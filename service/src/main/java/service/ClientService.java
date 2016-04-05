package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.ClientDAO;
import daoImpl.ClientDAOImpl;
import entity.Client;

@Service
public class ClientService {
    
    @Autowired
    private ClientDAO clientDao;
    
    public ClientService() {
        this.clientDao = new ClientDAOImpl();
    }
    
    @Transactional
    public void addClient(Client client) {
        clientDao.addElement(client);
    }
    
    @Transactional
    public void updateClient(Client client) {
        clientDao.updateElement(client);
    }
    
    @Transactional
    public Client getClientById(Long clientId) {
        return clientDao.getElementByID(clientId);
    }
    
    @Transactional
    public List<Client> getAllClients() {
        return clientDao.getAllElements();
    }
    
    @Transactional
    public void deleteBooking(Client client) {
        clientDao.deleteElement(client);
    }
    
    @Transactional
    public List<String> findAllCountriesClientVisited(Integer clientId) {
        return clientDao.getAllCountriesClientVisited(clientId);
    }
    
    @Transactional
    public List<Integer> countVisas(Integer clientId) {
    	return clientDao.countVisas(clientId);
    }

}
