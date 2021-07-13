package com.acfaudit.dto;

import java.util.List;

public class FindCollaborater {

    private int id;
    private String collaboraterFirstName;
    private String collaboraterSurName;
    private String collaboraterEmail;
    private List<FindClient> clientList;
    private List<FindFolder> folderList;

    public FindCollaborater() {
    }

    public FindCollaborater(String collaboraterFirstName, String collaboraterSurName, String collaboraterEmail) {
        this.collaboraterFirstName = collaboraterFirstName;
        this.collaboraterSurName = collaboraterSurName;
        this.collaboraterEmail = collaboraterEmail;
    }

    public FindCollaborater(int id,
                            String collaboraterFirstName,
                            String collaboraterSurName,
                            String collaboraterEmail,
                            List<FindClient> clientList,
                            List<FindFolder> folderList) {
        this.id = id;
        this.collaboraterFirstName = collaboraterFirstName;
        this.collaboraterSurName = collaboraterSurName;
        this.collaboraterEmail = collaboraterEmail;
        this.clientList = clientList;
        this.folderList = folderList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCollaboraterFirstName() {
        return collaboraterFirstName;
    }

    public void setCollaboraterFirstName(String collaboraterFirstName) {
        this.collaboraterFirstName = collaboraterFirstName;
    }

    public String getCollaboraterSurName() {
        return collaboraterSurName;
    }

    public void setCollaboraterSurName(String collaboraterSurName) {
        this.collaboraterSurName = collaboraterSurName;
    }

    public String getCollaboraterEmail() {
        return collaboraterEmail;
    }

    public void setCollaboraterEmail(String collaboraterEmail) {
        this.collaboraterEmail = collaboraterEmail;
    }

    public List<FindClient> getClientList() {
        return clientList;
    }

    public void setClientList(List<FindClient> clientList) {
        this.clientList = clientList;
    }

    public List<FindFolder> getFolderList() {
        return folderList;
    }

    public void setFolderList(List<FindFolder> folderList) {
        this.folderList = folderList;
    }
}
