package dao.impl;

import java.util.List;

import javax.persistence.Query;

import dao.ClientDAO;
import entity.Client;

public class ClientDAOImpl extends ElementDAOImpl<Client, Long> implements ClientDAO {
    
    public ClientDAOImpl() {
        super(Client.class);
    }
    
    @SuppressWarnings("unchecked")
    public List<String> getAllCountriesClientVisited(Integer clientId) {
        
    	Query getCountries = getEntityManager().createNamedQuery("getAllCountriesClientVisited");
        getCountries.setParameter("clientId", clientId);
        List<String> resultList = getCountries.getResultList();
        return resultList;
    }

    @SuppressWarnings("unchecked")
	public List<Integer> countVisas(Long clientId) {
		
		Query countVisas = getEntityManager().createNamedQuery("countVisas");
		countVisas.setParameter("clientId", clientId);
        List<Integer> resultList = countVisas.getResultList();
        return resultList;
	}
}
