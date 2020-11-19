package fr.ulco.ecom.dao;

import fr.ulco.ecom.model.Produit;
import fr.ulco.ecom.repository.EntityRepository;

import java.util.List;

public class ProduitDao implements EntityRepository<Produit> {

    @Override
    public Produit save(Produit o) {
        return null;
    }

    @Override
    public List<Produit> findAll() {
        return null;
    }

    @Override
    public Produit findOne(Long id) {
        return null;
    }

    @Override
    public Produit update(Produit o) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
