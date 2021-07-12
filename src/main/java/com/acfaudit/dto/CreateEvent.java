package com.acfaudit.dto;

import com.acfaudit.model.Document;
import com.acfaudit.model.Folder;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

public class CreateEvent {
    private int id;
    private LocalDateTime eventDate;
    private String eventTextContent;
    private Folder folder;
    private List<Document> documentList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventTextContent() {
        return eventTextContent;
    }

    public void setEventTextContent(String eventTextContent) {
        this.eventTextContent = eventTextContent;
    }

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }

    public List<Document> getDocumentList() {
        return documentList;
    }

    public void setDocumentList(List<Document> documentList) {
        this.documentList = documentList;
    }
}
