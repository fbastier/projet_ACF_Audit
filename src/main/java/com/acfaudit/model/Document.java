package com.acfaudit.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
public class Document {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "documentName")
    private String documentName;
    @Basic
    @Column(name = "documentLastModificationDate")
    private LocalDateTime documentLastModificationDate;
    @Basic
    @Column(name = "documentUpLoadDate")
    private LocalDateTime documentUploadDate;
    @Basic
    @Column(name = "documentPath")
    private String documentPath;
    @Basic
    @Column(name = "documentMessage")
    private String documentMessage;
    @ManyToOne
    @JoinColumn(name = "folder_id", nullable = false)
    private Folder folder;
    @ManyToMany (mappedBy = "documentList")
    private List<Event> eventList;

    public Document() {
    }

    public Document(String documentName, String documentPath, Folder folder) {
        this.documentName = documentName;
        this.documentPath = documentPath;
        this.folder = folder;
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

    public LocalDateTime getDocumentLastModificationDate() {
        return documentLastModificationDate;
    }

    public void setDocumentLastModificationDate(LocalDateTime documentLastModificationDate) {
        this.documentLastModificationDate = documentLastModificationDate;
    }

    public LocalDateTime getDocumentUpLoadDate() {
        return documentUploadDate;
    }

    public void setDocumentUpLoadDate(LocalDateTime documentUpLoadDate) {
        this.documentUploadDate = documentUpLoadDate;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return id == document.id && documentName.equals(document.documentName) && documentLastModificationDate.equals(document.documentLastModificationDate) && documentUploadDate.equals(document.documentUploadDate) && documentPath.equals(document.documentPath) && documentMessage.equals(document.documentMessage) && folder.equals(document.folder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, documentName, documentLastModificationDate, documentUploadDate, documentPath, documentMessage, folder);
    }
}
