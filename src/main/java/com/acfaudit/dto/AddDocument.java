package com.acfaudit.dto;

import com.acfaudit.model.Event;
import com.acfaudit.model.Folder;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

public class AddDocument {

    private int id;
    private String documentName;
    private String documentPath;
    private FindFolder findFolder;

    public AddDocument() {
    }

    public AddDocument(int id, String documentName, String documentPath, FindFolder findFolder) {
        this.id = id;
        this.documentName = documentName;
        this.documentPath = documentPath;
        this.findFolder = findFolder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentPath() {
        return documentPath;
    }

    public void setDocumentPath(String documentPath) {
        this.documentPath = documentPath;
    }

    public FindFolder getFindFolder() {
        return findFolder;
    }

    public void setFindFolder(FindFolder findFolder) {
        this.findFolder = findFolder;
    }
}
