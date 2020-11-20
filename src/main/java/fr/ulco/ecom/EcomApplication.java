package fr.ulco.ecom;

import fr.ulco.ecom.dao.ClientRepository;
import fr.ulco.ecom.model.Client;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EcomApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(EcomApplication.class, args);

//        ClientRepository clientRepository = context.getBean(ClientRepository.class);
//        Client client = new Client();
//        client.setEmail("test@test.com");
//        client.setPassword("123456");
//        client.setNom("test");
//        client.setAuthority("ROLE_USER");
//        client.setEnabled((short) 1);
//        clientRepository.save(client);
    }

}
