package dao;

import java.util.List;

import entity.Client;

public interface ClientDAO extends ElementDAO<Client, Long> {
    List<String> getAllCountriesClientVisited(Integer clientId);
    List<Integer> countVisas(Long clientId);
}
