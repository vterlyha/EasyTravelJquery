package dao.impl;


import java.util.List;

import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import dao.ClientDAO;
import entity.Client;

@Transactional
public class ClientDAOImpl extends ElementDAOImpl<Client, Long> implements ClientDAO {
    
    public ClientDAOImpl() {
        super(Client.class);
    }
    
    @Transactional
    @SuppressWarnings("unchecked")
    public List<String> getAllCountriesClientVisited(Integer clientId) {
          Query q = getEntityManager().createNamedQuery("getAllCountriesClientVisited");
          q.setParameter("clientId", clientId);
          List<String> resultList = q.getResultList();
        return resultList;
    }

}
