package com.acfaudit.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Objects;
import com.acfaudit.model.Client;

@Entity
public class Folder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "folderLastModificationDate")
    private Date folderLastModificationDate;

    @Basic
    @Column(name = "folderPath")
    private String folderPath;

    @OneToOne(mappedBy = "folder")
    private Client client;

    @ManyToMany(mappedBy = "folderList")
    private List<Collaborater> collaboraterList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFolderLastModificationDate() {
        return folderLastModificationDate;
    }

    public void setFolderLastModificationDate(Date folderLastModificationDate) {
        this.folderLastModificationDate = folderLastModificationDate;
    }

    public String getFolderPath() {
        return folderPath;
    }

    public void setFolderPath(String folderPath) {
        this.folderPath = folderPath;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Collaborater> getCollaboraterList() {
        return collaboraterList;
    }

    public void setCollaboraterList(List<Collaborater> collaboraterList) {
        this.collaboraterList = collaboraterList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Folder folder = (Folder) o;
        return id == folder.id && folderLastModificationDate.equals(folder.folderLastModificationDate) && folderPath.equals(folder.folderPath) && client.equals(folder.client) && collaboraterList.equals(folder.collaboraterList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, folderLastModificationDate, folderPath, client, collaboraterList);
    }
}
