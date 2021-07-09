package com.acfaudit.model;

import com.acfaudit.user.UserInterface;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Collaborater implements UserInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "collaboraterFirstName")
    private String collaboraterFirstName;

    @Basic
    @Column(name = "collaboraterSurName")
    private String collaboraterSurName;

    @Basic
    @Column(name = "collaboraterEmail")
    private String collaboraterEmail;

    @ManyToMany(mappedBy = "collaboraterList")
    private List<Client> clientList;

    @OneToMany(mappedBy = "collaborater")
    private List<Message> messageList;


    @ManyToMany
    @JoinTable (
            name = "collaborater_folder",
            joinColumns = @JoinColumn(name = "collaborater_id"),
            inverseJoinColumns = @JoinColumn(name = "folder_id")
    )
    private List<Folder> folderList;

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

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    public List<Folder> getFolderList() {
        return folderList;
    }

    public void setFolderList(List<Folder> folderList) {
        this.folderList = folderList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Collaborater that = (Collaborater) o;
        return id == that.id && collaboraterFirstName.equals(that.collaboraterFirstName) && collaboraterSurName.equals(that.collaboraterSurName) && collaboraterEmail.equals(that.collaboraterEmail) && clientList.equals(that.clientList) && messageList.equals(that.messageList) && folderList.equals(that.folderList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, collaboraterFirstName, collaboraterSurName, collaboraterEmail, clientList, messageList, folderList);
    }

    @Override
    public String toString() {
        return "Collaborater{" +
                "id=" + id +
                ", collaboraterFirstName='" + collaboraterFirstName + '\'' +
                ", collaboraterSurName='" + collaboraterSurName + '\'' +
                ", collaboraterEmail='" + collaboraterEmail + '\'' +
                ", clientList=" + clientList +
                ", messageList=" + messageList +
                ", folderList=" + folderList +
                '}';
    }
}
