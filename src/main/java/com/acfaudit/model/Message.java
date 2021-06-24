package com.acfaudit.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Message {
    private int id;
    private String messageContext;
    private Date messageTimeStamp;
    private int clientId;
    private int collaboraterId;
    private byte messageClientIsWriter;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "messageContext")
    public String getMessageContext() {
        return messageContext;
    }

    public void setMessageContext(String messageContext) {
        this.messageContext = messageContext;
    }

    @Basic
    @Column(name = "messageTimeStamp")
    public Date getMessageTimeStamp() {
        return messageTimeStamp;
    }

    public void setMessageTimeStamp(Date messageTimeStamp) {
        this.messageTimeStamp = messageTimeStamp;
    }

    @Basic
    @Column(name = "clientId")
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Basic
    @Column(name = "collaboraterId")
    public int getCollaboraterId() {
        return collaboraterId;
    }

    public void setCollaboraterId(int collaboraterId) {
        this.collaboraterId = collaboraterId;
    }

    @Basic
    @Column(name = "messageClientIsWriter")
    public byte getMessageClientIsWriter() {
        return messageClientIsWriter;
    }

    public void setMessageClientIsWriter(byte messageClientIsWriter) {
        this.messageClientIsWriter = messageClientIsWriter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return id == message.id && clientId == message.clientId && collaboraterId == message.collaboraterId && messageClientIsWriter == message.messageClientIsWriter && Objects.equals(messageContext, message.messageContext) && Objects.equals(messageTimeStamp, message.messageTimeStamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, messageContext, messageTimeStamp, clientId, collaboraterId, messageClientIsWriter);
    }
}
