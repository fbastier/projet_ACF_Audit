package com.acfaudit.calendar;

import com.acfaudit.dto.CreateEvent;
import com.acfaudit.folder.FolderRepository;
import com.acfaudit.model.Client;
import com.acfaudit.model.Event;
import com.acfaudit.model.Folder;
import com.acfaudit.user.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/calendrier")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private FolderRepository folderRepository;

    @Autowired
    private ClientRepository clientRepository;

    @PostMapping(path="/add")
    public @ResponseBody
    String addNewUser (@RequestBody CreateEvent createEvent) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        Event event = new Event();

        Client client = clientRepository.findById(1).get();
        Folder folder = client.getFolder();


        event.setEventTextContent(createEvent.getEventTextContent());
        event.setEventDate(createEvent.getEventDate());
        event.setFolder(folder);
        event.setDocumentList(folder.getDocumentList());

        //n.setFolder(folderRepository.findBy);
        eventRepository.save(event);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Event> getAllEvents() {
        // This returns a JSON or XML with the users
        return eventRepository.findAll();
    }
}
