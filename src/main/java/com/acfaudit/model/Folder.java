package com.acfaudit.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Folder {
    private int id;
    private Date folderLastModificationDate;
    private String folderPath;
    private int clientId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "folderLastModificationDate")
    public Date getFolderLastModificationDate() {
        return folderLastModificationDate;
    }

    public void setFolderLastModificationDate(Date folderLastModificationDate) {
        this.folderLastModificationDate = folderLastModificationDate;
    }

    @Basic
    @Column(name = "folderPath")
    public String getFolderPath() {
        return folderPath;
    }

    public void setFolderPath(String folderPath) {
        this.folderPath = folderPath;
    }

    @Basic
    @Column(name = "clientId")
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Folder folder = (Folder) o;
        return id == folder.id && clientId == folder.clientId && Objects.equals(folderLastModificationDate, folder.folderLastModificationDate) && Objects.equals(folderPath, folder.folderPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, folderLastModificationDate, folderPath, clientId);
    }
}
