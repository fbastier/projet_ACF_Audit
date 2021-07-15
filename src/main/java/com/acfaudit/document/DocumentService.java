package com.acfaudit.document;

import com.acfaudit.dto.AddDocument;
import com.acfaudit.dto.FindFolder;
import com.acfaudit.model.Document;
import com.acfaudit.model.Folder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;

@Service
public class DocumentService {

    @Autowired
    DocumentRepository documentRepository;

    public AddDocument save(String fileName, String path) {
        Folder folder = new Folder();
        folder.setId(1);
        Document document = documentRepository.save(new Document(fileName, path, folder));
        AddDocument addDocument = new AddDocument(
                document.getId(),
                document.getDocumentName(),
                document.getDocumentPath(),
                new FindFolder(document.getFolder().getId())
                );

        return addDocument;
    }

}
