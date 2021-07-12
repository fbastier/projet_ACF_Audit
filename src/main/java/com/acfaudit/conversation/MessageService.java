package com.acfaudit.conversation;

import com.acfaudit.dto.MessageCreate;
import com.acfaudit.model.Client;
import com.acfaudit.model.Collaborater;
import com.acfaudit.model.Message;
import com.acfaudit.user.UserInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Instant;


@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    MessageCreate messageCreate;

    // returns an instance of DTO MessageCreate but doesn't save it in database
    public MessageCreate createMessage(String messageContext, UserInterface client, UserInterface collaborater, Boolean clientIsWriter) {
        //Set messageContext
        messageCreate.setMessageContext(messageContext);
        // Set timestamp - sql date needs milliseconds timestamp to perform instanciation
        long timestamp = System.currentTimeMillis();
        messageCreate.setMessageTimeStamp(Instant.now());
        // Set client
        messageCreate.setClient((Client)client);
        //Set collaborater
        messageCreate.setCollaborater((Collaborater)collaborater);
        // Set clientIsWriter
        byte b = 0;
        if(clientIsWriter) {
            b = 1;
            messageCreate.setMessageClientIsWriter(b);
        } else {
            b = 0;
            messageCreate.setMessageClientIsWriter(b);
        }

        return messageCreate;
    }

    public MessageCreate saveMessage(MessageCreate messageCreate) {
        // Create an instance of Message Entity in order to persist it in Database
        Message message = new Message(messageCreate.getMessageContext(),
                messageCreate.getMessageTimeStamp(),
                messageCreate.getClient(),
                messageCreate.getCollaborater(),
                messageCreate.getMessageClientIsWriter());
        // Perform persistence
        messageRepository.save(message);
        return messageCreate;
    }

}
