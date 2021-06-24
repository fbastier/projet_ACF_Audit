package com.acfaudit.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Event {
    private int id;
    private Date eventDate;
    private String eventTextContent;
    private int folderId;
    private Integer documentId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "eventDate")
    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    @Basic
    @Column(name = "eventTextContent")
    public String getEventTextContent() {
        return eventTextContent;
    }

    public void setEventTextContent(String eventTextContent) {
        this.eventTextContent = eventTextContent;
    }

    @Basic
    @Column(name = "folderId")
    public int getFolderId() {
        return folderId;
    }

    public void setFolderId(int folderId) {
        this.folderId = folderId;
    }

    @Basic
    @Column(name = "documentId")
    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id && folderId == event.folderId && Objects.equals(eventDate, event.eventDate) && Objects.equals(eventTextContent, event.eventTextContent) && Objects.equals(documentId, event.documentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eventDate, eventTextContent, folderId, documentId);
    }
}
