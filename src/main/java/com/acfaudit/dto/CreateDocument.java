package com.acfaudit.dto;

import com.acfaudit.model.Event;
import com.acfaudit.model.Folder;

import java.sql.Date;
import java.util.List;

public class CreateDocument {
    private int id;
    private Date documentLastModificationDate;
    private Date documentUpLoadDate;
    private String documentPath;
    private String documentMessage;
    private Folder folder;
    private List<Event> eventList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDocumentLastModificationDate() {
        return documentLastModificationDate;
    }

    public void setDocumentLastModificationDate(Date documentLastModificationDate) {
        this.documentLastModificationDate = documentLastModificationDate;
    }

    public Date getDocumentUpLoadDate() {
        return documentUpLoadDate;
    }

    public void setDocumentUpLoadDate(Date documentUpLoadDate) {
        this.documentUpLoadDate = documentUpLoadDate;
    }

    public String getDocumentPath() {
        return documentPath;
    }

    public void setDocumentPath(String documentPath) {
        this.documentPath = documentPath;
    }

    public String getDocumentMessage() {
        return documentMessage;
    }

    public void setDocumentMessage(String documentMessage) {
        this.documentMessage = documentMessage;
    }

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

}
