package com.acfaudit.model;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "messageContext")
    private String messageContext;

    @Basic
    @Column(name = "messageTimeStamp")
    private Instant messageTimeStamp;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "collaborater_id", nullable = false)
    private Collaborater collaborater;

    @Basic
    @Column(name = "messageClientIsWriter")
    private byte messageClientIsWriter;

    public Message() {
    }

    public Message(String messageContext, Instant messageTimeStamp, Client client, Collaborater collaborater, byte messageClientIsWriter) {
        this.messageContext = messageContext;
        this.messageTimeStamp = messageTimeStamp;
        this.client = client;
        this.collaborater = collaborater;
        this.messageClientIsWriter = messageClientIsWriter;
    }

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

    public Instant getMessageTimeStamp() {
        return messageTimeStamp;
    }

    public void setMessageTimeStamp(Instant messageTimeStamp) {
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
        return id == message.id && messageClientIsWriter == message.messageClientIsWriter && messageContext.equals(message.messageContext) && messageTimeStamp.equals(message.messageTimeStamp) && client.equals(message.client) && collaborater.equals(message.collaborater);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, messageContext, messageTimeStamp, client, collaborater, messageClientIsWriter);
    }
}
