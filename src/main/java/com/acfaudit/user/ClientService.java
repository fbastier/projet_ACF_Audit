package com.acfaudit.user;

import com.acfaudit.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public Client findByEmail(String email) {
        Client client = clientRepository.findUserByClientEmail(email);
        return client;
        }
}
