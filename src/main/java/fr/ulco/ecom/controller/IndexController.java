package fr.ulco.ecom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping(value = "/")
    public String home(Model model) {
        return "redirect:/user";
    }

    @RequestMapping(value = "/user")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping(value = "/403")
    public String accessDenied(Model model) {
        return "error/403";
    }

    @RequestMapping(value = "/404")
    public String pageNotFound(Model model) {
        return "error/404";
    }
}
