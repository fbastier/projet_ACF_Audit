package com.acfaudit.dto;

import com.acfaudit.model.Collaborater;
import com.acfaudit.model.Message;

import java.util.List;

public class FindClient {
    private int id;
    private String firstName;
    private String surName;
    private String email;
    private int folder;
    private List<FindCollaborater> collaboraterList;

    public FindClient() {
    }

    public FindClient(int id, String firstName, String surName, String email, int folder, List<FindCollaborater> collaboraterList) {
        this.id = id;
        this.firstName = firstName;
        this.surName = surName;
        this.email = email;
        this.folder = folder;
        this.collaboraterList = collaboraterList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getFolder() {
        return folder;
    }

    public void setFolder(int folder) {
        this.folder = folder;
    }

    public List<FindCollaborater> getCollaboraterList() {
        return collaboraterList;
    }

    public void setCollaboraterList(List<FindCollaborater> collaboraterList) {
        this.collaboraterList = collaboraterList;
    }

}
