package fr.ulco.ecom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * contient les services d’accès au catalogue
 * de la e-boutique, en particulier pour l’accès aux catégories et aux produits
 */
@Controller
public class CatalogueController {

    @RequestMapping(value = "/user/catalogue", method = RequestMethod.GET)
    public String redirect1() {
        return "redirect:/user";
    }

    @RequestMapping(value = "/catalogue", method = RequestMethod.GET)
    public String redirect2() {
        return "redirect:/user";
    }
}
