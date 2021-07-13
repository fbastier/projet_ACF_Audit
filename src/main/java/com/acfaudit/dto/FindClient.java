package com.acfaudit.dto;

import com.acfaudit.model.Collaborater;
import com.acfaudit.model.Message;

import java.util.List;

public class FindClient {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private int folder;
    private List<FindCollaborater> collaboraterList;

    public FindClient() {
    }

    public FindClient(int id, String firstName, String surName, String email, int folder, List<FindCollaborater> collaboraterList) {
        this.id = id;
        this.firstname = firstName;
        this.lastname = surName;
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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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
