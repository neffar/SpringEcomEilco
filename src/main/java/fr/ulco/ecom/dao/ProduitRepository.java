package fr.ulco.ecom.dao;


import fr.ulco.ecom.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
}