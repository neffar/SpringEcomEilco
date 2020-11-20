package fr.ulco.ecom.controller;

import fr.ulco.ecom.dao.ClientRepository;
import fr.ulco.ecom.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(value = "/client")
public class ClientController {

    final private ClientRepository clientRepository;

    @Autowired
    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String register() {
        return "auth/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void addClient(@ModelAttribute("client") Client client, BindingResult result, HttpServletResponse response) throws IOException {
        if (!result.hasErrors()) {
            client.setAuthority("ROLE_USER");
            client.setEnabled((short) 1);
            clientRepository.save(client);
        }
        response.sendRedirect("/login");
    }
}
