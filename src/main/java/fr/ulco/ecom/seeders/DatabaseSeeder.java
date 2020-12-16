package fr.ulco.ecom.seeders;

import fr.ulco.ecom.dao.CategorieRepository;
import fr.ulco.ecom.dao.ClientRepository;
import fr.ulco.ecom.dao.ProduitRepository;
import fr.ulco.ecom.model.Categorie;
import fr.ulco.ecom.model.Client;
import fr.ulco.ecom.model.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class DatabaseSeeder {

    final private CategorieRepository categorieRepository;
    final private ClientRepository clientRepository;
    final private ProduitRepository produitRepository;
    final private JdbcTemplate jdbcTemplate;

    @Autowired
    public DatabaseSeeder(CategorieRepository categorieRepository, ClientRepository clientRepository, ProduitRepository produitRepository, JdbcTemplate jdbcTemplate) {
        this.categorieRepository = categorieRepository;
        this.clientRepository = clientRepository;
        this.produitRepository = produitRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedUser();
        seedCategories();
        seedProducts();
    }

    private void seedCategories() {
        String dc0 = "DVD", dc1 = "Ordinateurs", dc2 = "Accessoires", dc3 = "Téléphones", dc4 = "Parfumes";
        String sql = "SELECT nom FROM categorie c WHERE c.nom IN (\"" + dc0 + "\", \"" + dc1 + "\", \"" + dc2 + "\", \"" + dc3 + "\", \"" + dc4 + "\")";
        List<Categorie> rs = jdbcTemplate.query(sql, (resultSet, rowNum) -> null);
        if (rs.size() <= 0) {
            Categorie c = new Categorie("DVD");
            Categorie c2 = new Categorie("Ordinateurs");
            Categorie c3 = new Categorie("Accessoires");
            Categorie c4 = new Categorie("Téléphones");
            Categorie c5 = new Categorie("Parfumes");
            categorieRepository.save(c);
            categorieRepository.save(c2);
            categorieRepository.save(c3);
            categorieRepository.save(c4);
            categorieRepository.save(c5);
            System.out.println("category table seeded");
        } else {
            System.out.println("Category Seeding Not Required");
        }
    }

    private void seedProducts() {
        String sql = "SELECT p.id FROM produit p";
        List<Client> u = jdbcTemplate.query(sql, (resultSet, rowNum) -> null);
        if (u.size() <= 30) {
            int id = 1;
            for (int i = 1; i <= 30; i++) {
                if (id > 5)
                    id = 1;
                Produit produit = new Produit();
                produit.setDescription("Lorem ipsum, or lipsum as it is sometimes known, is dummy text used in laying out print, graphic or web designs");
                produit.setNom("Produit " + i);
                float random = (float) (50 + Math.random() * 300);
                produit.setPrix(random);

                List<Categorie> tempCat = Arrays.stream(new long[]{(long) id})
                        .mapToObj(categorieRepository::findById)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .collect(Collectors.toList());
                id++;
                produit.setCategorie(tempCat.get(0));
                produitRepository.save(produit);

            }
            System.out.println("Produits Seeded");
        } else {
            System.out.println("Produits Seeding Not Required");
        }
    }

    private void seedUser() {
        String sql = "SELECT email FROM client c WHERE c.email = \"neffar@bourichi.fr\" LIMIT 1";
        List<Client> u = jdbcTemplate.query(sql, (resultSet, rowNum) -> null);
        if (u.size() <= 0) {
            Client user = new Client();
            user.setNom("Neffar & Bourichi");
            user.setEmail("neffar@bourichi.fr");
            user.setPassword(new BCryptPasswordEncoder().encode("eilco123"));
            user.setAdresse("EILCO ULCO France Calais");
            user.setTelephone("01 22 44 66 88");
            user.setAuthority("ROLE_USER");
            user.setEnabled((short) 1);
            clientRepository.save(user);
            System.out.println("Users Seeded");
        } else {
            System.out.println("Users Seeding Not Required");
        }
    }
}
