package com.acfaudit.model;

import com.acfaudit.user.UserInterface;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Client implements UserInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "username")
    private String username;

    @Basic
    @Column(name = "clientFirstName")
    private String clientFirstName;

    @Basic
    @Column(name = "clientSurName")
    private String clientSurName;

    @Basic
    @Column(name = "clientEmail")
    private String email;

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

    @Basic
    @Column(name = "active")
    private boolean active;

    @Basic
    @Column(name = "roles")
    private String roles;


    @Basic
    @Column(name = "password")
    private String password;

    public Client() {

    }

    // NEEDED FOR AUTHENTICATION CONSTRUCTOR
    public Client(int id, String clientFirstName, String email, boolean active, String roles) {
        this.id = id;
        this.clientFirstName = clientFirstName;
        this.email = email;
        this.active = active;
        this.roles = roles;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String clientEmail) {
        this.email = clientEmail;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id && clientFirstName.equals(client.clientFirstName) && clientSurName.equals(client.clientSurName) && email.equals(client.email) && messageList.equals(client.messageList) && folder.equals(client.folder) && collaboraterList.equals(client.collaboraterList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientFirstName, clientSurName, email, messageList, folder, collaboraterList);
    }

    /*@Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", clientFirstName='" + clientFirstName + '\'' +
                ", clientSurName='" + clientSurName + '\'' +
                ", clientEmail='" + clientEmail + '\'' +
                ", messageList=" + messageList +
                ", folder=" + folder +
                ", collaboraterList=" + collaboraterList +
                '}';
    }*/
}
