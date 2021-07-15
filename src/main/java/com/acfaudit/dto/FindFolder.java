package com.acfaudit.dto;

import com.acfaudit.model.Client;
import com.acfaudit.model.Collaborater;
import com.acfaudit.model.Document;
import com.acfaudit.model.Event;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

public class FindFolder {

    private int id;
    private Date folderLastModificationDate;
    private String folderPath;
    private FindClient client;
    private List<FindCollaborater> collaboraterList;

    public FindFolder() {
    }

    public FindFolder(int id) {
        this.id = id;
    }

    public FindFolder(int id, Date folderLastModificationDate, String folderPath, FindClient client, List<FindCollaborater> collaboraterList) {
        this.id = id;
        this.folderLastModificationDate = folderLastModificationDate;
        this.folderPath = folderPath;
        this.client = client;
        this.collaboraterList = collaboraterList;
    }

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

    public FindClient getClient() {
        return client;
    }

    public void setClient(FindClient client) {
        this.client = client;
    }

    public List<FindCollaborater> getCollaboraterList() {
        return collaboraterList;
    }

    public void setCollaboraterList(List<FindCollaborater> collaboraterList) {
        this.collaboraterList = collaboraterList;
    }
}
