package com.acfaudit.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "eventDate")
    private LocalDateTime eventDate;
    @Basic
    @Column(name = "eventTextContent")
    private String eventTextContent;

    @ManyToOne
    @JoinColumn(name = "folder_id", nullable = false)
    private Folder folder;

    @ManyToMany
    @JoinTable (
            name = "document_event",
            joinColumns = @JoinColumn(name = "document_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id")
    )
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id && eventDate.equals(event.eventDate) && eventTextContent.equals(event.eventTextContent) && folder.equals(event.folder) && documentList.equals(event.documentList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eventDate, eventTextContent, folder, documentList);
    }
}
