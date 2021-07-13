package com.acfaudit.user;

import com.acfaudit.dto.FindClient;
import com.acfaudit.dto.AddClient;
import com.acfaudit.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path="/client")
@CrossOrigin(origins = "http://localhost:4200/")
public class ClientController {


    @Autowired
    private ClientService clientService;


    @GetMapping(path="/add")
    public @ResponseBody String addView() {
        return "form";
    }


    @PostMapping(path="/addNewClient")
    public @ResponseBody String addNewClient (@ModelAttribute("AddClient") AddClient addClient,
                                            @ModelAttribute("CollaboraterId") int collaboraterId) {
        Client client = clientService.save(addClient, collaboraterId);

        return client.toString();
    }


    @GetMapping(path="/all")
    @CrossOrigin(value = "localhost:4200/client-list")
    public @ResponseBody List<FindClient> getAllClients() {
        clientService.findAll();

        List<FindClient> clientResponseList = new ArrayList<FindClient>();

        ArrayList<FindClient> findClients = (ArrayList<FindClient>)clientService.findAll();
        System.out.println(findClients);

        return findClients;
    }

}
