package com.acfaudit.dto;

import com.acfaudit.model.Client;
import com.acfaudit.model.Collaborater;
import org.springframework.stereotype.Component;

import java.time.Instant;

// Data Transfer Object for creating messages
@Component
public class MessageCreate {
    private String messageContext;
    private Instant messageTimeStamp;
    private Client client;
    private Collaborater collaborater;
    private byte messageClientIsWriter;

    public String getMessageContext() {
        return messageContext;
    }

    public void setMessageContext(String messageContext) {
        this.messageContext = messageContext;
    }

    public Instant getMessageTimeStamp() {
        return messageTimeStamp;
    }

    public void setMessageTimeStamp(Instant instant) {
        this.messageTimeStamp = instant;
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

    public byte getMessageClientIsWriter() {
        return messageClientIsWriter;
    }

    public void setMessageClientIsWriter(byte messageClientIsWriter) {
        this.messageClientIsWriter = messageClientIsWriter;
    }
}
