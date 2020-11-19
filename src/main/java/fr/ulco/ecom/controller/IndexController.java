package fr.ulco.ecom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/index")
public class IndexController {

    @RequestMapping(value = "/")
    public String index(Model model) {
        return "index";
    }
}
