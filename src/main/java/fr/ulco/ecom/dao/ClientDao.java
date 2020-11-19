package fr.ulco.ecom.dao;

import fr.ulco.ecom.model.Client;
import fr.ulco.ecom.repository.EntityRepository;

import java.util.List;

public class ClientDao implements EntityRepository<Client> {
    @Override
    public Client save(Client o) {
        return null;
    }

    @Override
    public List<Client> findAll() {
        return null;
    }

    @Override
    public Client findOne(Long id) {
        return null;
    }

    @Override
    public Client update(Client o) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
