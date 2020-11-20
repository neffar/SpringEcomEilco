package fr.ulco.ecom.controller;

import fr.ulco.ecom.dao.CategorieRepository;
import fr.ulco.ecom.dao.ProduitRepository;
import fr.ulco.ecom.model.Categorie;
import fr.ulco.ecom.model.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * contient les services d’accès au catalogue
 * de la e-boutique, en particulier pour l’accès aux catégoriesaux et aux produits
 */
@RestController
@RequestMapping(value = "/api")
public class CatalogueController {

    private CategorieRepository categorieRepository;
    private ProduitRepository produitRepository;

    @Autowired
    public CatalogueController(CategorieRepository categorieRepository, ProduitRepository produitRepository) {
        this.categorieRepository = categorieRepository;
        this.produitRepository = produitRepository;
    }

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public List<Categorie> getCategories() {
        return categorieRepository.findAll();
    }

    @RequestMapping(value = "/produits", method = RequestMethod.GET)
    public List<Produit> getProduits() {
        return produitRepository.findAll();
    }
}
