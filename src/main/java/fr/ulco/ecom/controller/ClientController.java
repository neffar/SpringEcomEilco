package fr.ulco.ecom.controller;

import fr.ulco.ecom.dao.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/client")
public class ClientController {

    final private ClientRepository clientRepository;

    @Autowired
    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @RequestMapping(value = "")
    public String register(Model model) {
        return "auth/register";
    }

    @RequestMapping(value = "/register")
    public String addClient(Model model) {
        return null;
    }
}
