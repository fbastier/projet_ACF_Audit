package com.acfaudit.dto;

import javax.persistence.*;

import com.acfaudit.model.Client;
import com.acfaudit.model.Collaborater;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class CreateMessage {
    private int id;
    private String messageContext;
    private LocalDateTime messageTimeStamp;
    private Client client;
    private Collaborater collaborater;
    private boolean messageClientIsWriter;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessageContext() {
        return messageContext;
    }

    public void setMessageContext(String messageContext) {
        this.messageContext = messageContext;
    }

    public LocalDateTime getMessageTimeStamp() {
        return messageTimeStamp;
    }

    public void setMessageTimeStamp(LocalDateTime messageTimeStamp) {
        this.messageTimeStamp = messageTimeStamp;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Collaborater getCollaborater() {
        return collaborater;
    }

    public void setCollaborater(Collaborater collaborater) {
        this.collaborater = collaborater;
    }

    public boolean getMessageClientIsWriter() {
        return messageClientIsWriter;
    }

    public void setMessageClientIsWriter(boolean messageClientIsWriter) {
        this.messageClientIsWriter = messageClientIsWriter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateMessage message = (CreateMessage) o;
        return id == message.id && messageClientIsWriter == message.messageClientIsWriter && messageContext.equals(message.messageContext) && messageTimeStamp.equals(message.messageTimeStamp) && client.equals(message.client) && collaborater.equals(message.collaborater);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, messageContext, messageTimeStamp, client, collaborater, messageClientIsWriter);
    }
}
