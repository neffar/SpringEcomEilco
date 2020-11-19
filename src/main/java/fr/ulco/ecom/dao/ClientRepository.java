package fr.ulco.ecom.dao;

import fr.ulco.ecom.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}