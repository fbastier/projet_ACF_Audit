package com.acfaudit.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "clientFirstName")
    private String clientFirstName;

    @Basic
    @Column(name = "clientSurName")
    private String clientSurName;

    @Basic
    @Column(name = "clientEmail")
    private String clientEmail;

    @OneToMany(mappedBy = "client")
    private List<Message> messageList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "folder_id", referencedColumnName = "id")
    private Folder folder;

    @ManyToMany
    @JoinTable (
            name = "collaborater_client",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "collaborater_id")
    )
    private List<Collaborater> collaboraterList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClientFirstName() {
        return clientFirstName;
    }

    public void setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName;
    }

    public String getClientSurName() {
        return clientSurName;
    }

    public void setClientSurName(String clientSurName) {
        this.clientSurName = clientSurName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }

    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
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
        Client client = (Client) o;
        return id == client.id && clientFirstName.equals(client.clientFirstName) && clientSurName.equals(client.clientSurName) && clientEmail.equals(client.clientEmail) && messageList.equals(client.messageList) && folder.equals(client.folder) && collaboraterList.equals(client.collaboraterList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientFirstName, clientSurName, clientEmail, messageList, folder, collaboraterList);
    }
}
