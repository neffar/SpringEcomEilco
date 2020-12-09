package fr.ulco.ecom.controller;

import fr.ulco.ecom.dao.ProduitRepository;
import fr.ulco.ecom.model.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping(value = "/user/commande")
public class RestCommandeController {

    final private ProduitRepository produitRepository;

    @Autowired
    public RestCommandeController(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @RequestMapping(value = "buy/{id}", method = RequestMethod.GET)
    public void buy(@PathVariable("id") String id, HttpServletRequest request) {
        if (request.getSession().getAttribute("cart") == null) {

            List<Produit> produits = Arrays.stream(new long[]{Long.parseLong(id)})
                    .mapToObj(produitRepository::findById)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());

            request.getSession().setAttribute("cart", produits);
        } else {
            List<Produit> cart = (List<Produit>) request.getSession().getAttribute("cart");
            List<Produit> produits = Arrays.stream(new long[]{Long.parseLong(id)})
                    .mapToObj(produitRepository::findById)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList());

            List<Produit> newList = Stream.concat(cart.stream(), produits.stream()).collect(Collectors.toList());

            request.getSession().setAttribute("cart", newList);
            System.out.println(newList);
        }
    }
}
