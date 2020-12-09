package fr.ulco.ecom.controller;

import fr.ulco.ecom.dao.ProduitRepository;
import fr.ulco.ecom.model.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user/commande")
public class RestCommandeController {

    final private ProduitRepository produitRepository;

    @Autowired
    public RestCommandeController(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @RequestMapping(value = "buy/{id}", method = RequestMethod.GET)
    public void buy(@PathVariable("id") String id, HttpSession session) {
        if(session.getAttribute("cart") == null) {
            List<Optional<Produit>> cart = new ArrayList<>();
            cart.add(produitRepository.findById(Long.parseLong(id)));
            session.setAttribute("cart", cart);
        } else {
            List<Optional<Produit>> cart = (List<Optional<Produit>>) session.getAttribute("cart");
            cart.add(produitRepository.findById(Long.parseLong(id)));
            session.setAttribute("cart", cart);
        }
    }
}
