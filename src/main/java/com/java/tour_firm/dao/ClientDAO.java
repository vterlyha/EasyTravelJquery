package com.java.tour_firm.dao;

import java.util.List;

import javax.persistence.Query;

import com.java.tour_firm.entity.Client;

public class ClientDAO extends ElementDAOImpl<Client> {
    
    public ClientDAO() {
        super(Client.class);
    }
    
    public List<String> getAllCountriesClientVisited(Integer clientId) {
        List<String> resultList;
        try {
          eManager = emf.createEntityManager();
          Query q = eManager.createNamedQuery("getAllCountriesClientVisited");
          q.setParameter("clientId", clientId);
          resultList = q.getResultList();
          eManager.close();
          emf.close();
        }
        catch(RuntimeException e) {
            if (eTransaction.isActive())
                eTransaction.rollback();
            throw e;
        }
        return resultList;
    }

}
