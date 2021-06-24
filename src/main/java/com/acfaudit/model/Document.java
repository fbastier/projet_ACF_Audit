package com.acfaudit.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Document {
    private int id;
    private String documentName;
    private Date documentLastModificationDate;
    private Date documentUpLoadDate;
    private String documentPath;
    private String documentMessage;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "documentName")
    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    @Basic
    @Column(name = "documentLastModificationDate")
    public Date getDocumentLastModificationDate() {
        return documentLastModificationDate;
    }

    public void setDocumentLastModificationDate(Date documentLastModificationDate) {
        this.documentLastModificationDate = documentLastModificationDate;
    }

    @Basic
    @Column(name = "documentUpLoadDate")
    public Date getDocumentUpLoadDate() {
        return documentUpLoadDate;
    }

    public void setDocumentUpLoadDate(Date documentUpLoadDate) {
        this.documentUpLoadDate = documentUpLoadDate;
    }

    @Basic
    @Column(name = "documentPath")
    public String getDocumentPath() {
        return documentPath;
    }

    public void setDocumentPath(String documentPath) {
        this.documentPath = documentPath;
    }

    @Basic
    @Column(name = "documentMessage")
    public String getDocumentMessage() {
        return documentMessage;
    }

    public void setDocumentMessage(String documentMessage) {
        this.documentMessage = documentMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return id == document.id && Objects.equals(documentName, document.documentName) && Objects.equals(documentLastModificationDate, document.documentLastModificationDate) && Objects.equals(documentUpLoadDate, document.documentUpLoadDate) && Objects.equals(documentPath, document.documentPath) && Objects.equals(documentMessage, document.documentMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, documentName, documentLastModificationDate, documentUpLoadDate, documentPath, documentMessage);
    }
}
