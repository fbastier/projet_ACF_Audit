package com.acfaudit.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Client {
    private int id;
    private String clientFirstName;
    private String clientSurName;
    private String clientEmail;
    private int folderId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "clientFirstName")
    public String getClientFirstName() {
        return clientFirstName;
    }

    public void setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName;
    }

    @Basic
    @Column(name = "clientSurName")
    public String getClientSurName() {
        return clientSurName;
    }

    public void setClientSurName(String clientSurName) {
        this.clientSurName = clientSurName;
    }

    @Basic
    @Column(name = "clientEmail")
    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    @Basic
    @Column(name = "folderId")
    public int getFolderId() {
        return folderId;
    }

    public void setFolderId(int folderId) {
        this.folderId = folderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id && folderId == client.folderId && Objects.equals(clientFirstName, client.clientFirstName) && Objects.equals(clientSurName, client.clientSurName) && Objects.equals(clientEmail, client.clientEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientFirstName, clientSurName, clientEmail, folderId);
    }
}
