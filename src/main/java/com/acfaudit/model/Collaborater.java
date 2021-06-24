package com.acfaudit.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Collaborater {
    private int id;
    private String collaboraterFirstName;
    private String collaboraterSurName;
    private String collaboraterEmail;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "collaboraterFirstName")
    public String getCollaboraterFirstName() {
        return collaboraterFirstName;
    }

    public void setCollaboraterFirstName(String collaboraterFirstName) {
        this.collaboraterFirstName = collaboraterFirstName;
    }

    @Basic
    @Column(name = "collaboraterSurName")
    public String getCollaboraterSurName() {
        return collaboraterSurName;
    }

    public void setCollaboraterSurName(String collaboraterSurName) {
        this.collaboraterSurName = collaboraterSurName;
    }

    @Basic
    @Column(name = "collaboraterEmail")
    public String getCollaboraterEmail() {
        return collaboraterEmail;
    }

    public void setCollaboraterEmail(String collaboraterEmail) {
        this.collaboraterEmail = collaboraterEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Collaborater that = (Collaborater) o;
        return id == that.id && Objects.equals(collaboraterFirstName, that.collaboraterFirstName) && Objects.equals(collaboraterSurName, that.collaboraterSurName) && Objects.equals(collaboraterEmail, that.collaboraterEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, collaboraterFirstName, collaboraterSurName, collaboraterEmail);
    }
}
