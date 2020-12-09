package fr.ulco.ecom.controller;

import fr.ulco.ecom.dao.ProduitRepository;
import fr.ulco.ecom.model.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * contient les services de gestion des commandes et panier
 */
@Transactional
@Controller
@RequestMapping(value = "/user/commande")
public class CommandeController {

    final private ProduitRepository produitRepository;

    @Autowired
    public CommandeController(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @RequestMapping(value = "")
    public String cart(Model model, HttpServletRequest request) {
        List<Produit> cart = (ArrayList<Produit>) request.getSession().getAttribute("cart");
        model.addAttribute("cart", cart);
        return "cart/index";
    }

    @RequestMapping(value = "remove/{id}", method = RequestMethod.GET)
    public String remove(@PathVariable("id") String id, HttpServletRequest request) {
        List<Produit> cart = (ArrayList<Produit>) request.getSession().getAttribute("cart");
        request.getSession().removeAttribute("cart");
        request.getSession().invalidate();
        cart.remove(produitRepository.findById(Long.parseLong(id)));
        request.getSession().setAttribute("cart", cart);
        return "redirect:/user/commande";
    }
}
