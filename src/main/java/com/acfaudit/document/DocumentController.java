package com.acfaudit.document;

import com.acfaudit.calendar.EventRepository;
import com.acfaudit.dto.CreateDocument;
import com.acfaudit.dto.CreateEvent;
import com.acfaudit.folder.FolderRepository;
import com.acfaudit.model.Client;
import com.acfaudit.model.Document;
import com.acfaudit.model.Folder;
import com.acfaudit.user.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;

@Controller
@RequestMapping(path = "/documents")
public class DocumentController {
    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private FolderRepository folderRepository;

    @Autowired
    private ClientRepository clientRepository;

    @PostMapping(path="/add")
    public @ResponseBody
    String addNewDocument (@RequestBody CreateDocument createDocument) {
        Document document = new Document();

        // TODO : change this
        Client client = clientRepository.findById(1).get();
        Folder folder = client.getFolder();

        document.setDocumentName("leDocdeJean");
        document.setFolder(folder);

        return "Saved";
    }
}
