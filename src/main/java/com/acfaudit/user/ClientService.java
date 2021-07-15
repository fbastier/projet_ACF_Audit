package com.acfaudit.user;

import com.acfaudit.dto.AddClient;
import com.acfaudit.dto.FindClient;
import com.acfaudit.dto.FindCollaborater;
import com.acfaudit.folder.FolderRepository;
import com.acfaudit.model.Client;
import com.acfaudit.model.Collaborater;
import com.acfaudit.model.Folder;
import com.acfaudit.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ClientService {


    @Autowired
    private ClientRepository clientRepository;


    @Autowired
    private FolderRepository folderRepository;


    @Autowired
    private CollaboraterRepository collaboraterRepository;


    // FINDBYEMAIL()
    public Client findByEmail(String email) {
        Client client = clientRepository.findUserByClientEmail(email);

        return client;
    }


    // FINDALL()
    // Corresponds to URL "client/all"
    public List<FindClient> findAll() {
        Iterable<Client> clients = clientRepository.findAll();

        List<FindClient> findClients = new ArrayList<>();
        System.out.println("############");

        // Builds each findClient to be returned
        for (Client c :
                clients) {

            // Builds findCollaboraters list
            List<FindCollaborater> findCollaboraters = new ArrayList<>();
            List<Collaborater> collaboraterList = c.getCollaboraterList();
            for (Collaborater co :
                    collaboraterList) {
                FindCollaborater fc = new FindCollaborater(
                        co.getCollaboraterFirstName(),
                        co.getCollaboraterSurName(),
                        co.getCollaboraterEmail());
                findCollaboraters.add(fc);
            }

            // Builds findClients using findCollaboraters list
            findClients.add(new FindClient(
                    c.getId(),
                    c.getClientFirstName(),
                    c.getClientSurName(),
                    c.getClientEmail(),
                    c.getFolder().getId(),
                    findCollaboraters
                    ));
        }

        System.out.println("findClients : ");
        System.out.println(findClients);
        System.out.println("############");

        return findClients;
    }


    // ADD()
    // Corresponds to URL "client/add"
    public Client save(AddClient addClient, int collaboraterId) {

        // Initialize collaborater list for this new client
        Collaborater collaborater = collaboraterRepository.findById(collaboraterId).get();
        List<Collaborater> cL = new ArrayList<Collaborater>();
        cL.add(collaborater);

        // Initialize message list
        List<Message> mL = new ArrayList<Message>();

        // Create this new client's folder
        Folder f = new Folder();
        f = folderRepository.save(f);

        // Add new client in database
        Client client = new Client();
        client.setClientFirstName(addClient.getFirstName());
        client.setClientSurName(addClient.getSurName());
        client.setClientEmail(addClient.getEmail());
        client.setFolder(f);
        client.setMessageList(mL);
        client.setCollaboraterList(cL);
        client.setActive(true);
        client.setRoles("ROLE_USER");
        // Initialize random password using Java streams
        Random random = new Random();
        int[] randomIntsArray = random.ints(10000, 100000).limit(4).toArray();
        String password = Arrays.stream(randomIntsArray)
                .mapToObj((i) -> String.valueOf(i))
                .collect(Collectors.joining("-"));
        client.setPassword(password);
        client = clientRepository.save(client);

        return client;
    }

    public Client findByUsername(String username) {
        Client client = clientRepository.findByUsername(username);

        return client;
    }
}
