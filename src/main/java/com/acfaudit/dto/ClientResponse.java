package com.acfaudit.dto;

import com.acfaudit.model.Collaborater;
import com.acfaudit.model.Message;

import java.util.List;

public class ClientResponse {
    private int id;
    private String firstName;
    private String surName;
    private String email;
    private int folder;
    private List<Collaborater> collaboraterList;
    private List<Message> messageList;

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

    public List<Collaborater> getCollaboraterList() {
        return collaboraterList;
    }

    public void setCollaboraterList(List<Collaborater> collaboraterList) {
        this.collaboraterList = collaboraterList;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }
}
