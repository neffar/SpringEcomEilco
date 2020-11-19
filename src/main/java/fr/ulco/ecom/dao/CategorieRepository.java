package fr.ulco.ecom.dao;

import fr.ulco.ecom.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}