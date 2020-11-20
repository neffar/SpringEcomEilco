package fr.ulco.ecom.dao;


import fr.ulco.ecom.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProduitRepository extends JpaRepository<Produit, Long> {
}