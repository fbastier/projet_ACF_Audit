package com.acfaudit.user;

import com.acfaudit.model.Client;
import com.acfaudit.model.Folder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller // This means that this class is a Controller
@RequestMapping(path="/client") // This means URL's start with /demo (after Application path)
public class ClientController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private ClientRepository clientRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam String firstName,
                                            @RequestParam String surName,
                                            @RequestParam String email,
                                            @RequestParam int folder_id) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Client n = new Client();
        n.setClientFirstName(firstName);
        n.setClientSurName(surName);
        n.setClientEmail(email);
        //n.setFolder(folderRepository.findBy);
        clientRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Client> getAllUsers() {
        // This returns a JSON or XML with the users
        return clientRepository.findAll();
    }
}
