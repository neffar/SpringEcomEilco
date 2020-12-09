package fr.ulco.ecom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * contient les services de gestion des commandes et panier
 */
@Controller
@RequestMapping(value = "/user/commande")
public class CommandeController {

    @RequestMapping(value = "")
    public String cart(Model model, HttpSession session) {
        String cart = "test";
        model.addAttribute("cart", cart);
        return "cart/index";
    }

    @RequestMapping(value = "remove/{id}", method = RequestMethod.GET)
    public String remove(@PathVariable("id") String id, HttpSession session) {
        return null;
    }
}
