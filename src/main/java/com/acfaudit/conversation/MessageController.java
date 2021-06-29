package com.acfaudit.conversation;

import java.time.LocalDateTime;

import com.acfaudit.dto.CreateMessage;
import com.acfaudit.model.Client;
import com.acfaudit.model.Collaborater;
import com.acfaudit.model.Message;
import com.acfaudit.user.ClientRepository;
import com.acfaudit.user.CollaboraterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/msg")
public class MessageController {
    @Autowired
    MessageRepository msgRepository;

    @Autowired
    ClientRepository cliRepository;

    @Autowired
    CollaboraterRepository colRepository;

    @PostMapping(path="/send")
    public @ResponseBody
    String newMsg (@RequestBody CreateMessage msg, @RequestBody int id_user, @RequestBody int id_cli, @RequestBody int id_col) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        Message newMsg = new Message();

        Client client = cliRepository.findById(id_cli).get();
        Collaborater colab = colRepository.findById(id_col).get();
        newMsg.setClient(client);
        newMsg.setCollaborater(colab);;
        newMsg.setMessageContext(msg.getMessageContext());
        newMsg.setMessageTimeStamp(LocalDateTime.now());
        
        //TODO : Find a beeter way to determine the writer
        newMsg.setMessageClientIsWriter(id_user == id_col ? false : true);
      
        msgRepository.save(newMsg);
        return "Send";
    }

    @GetMapping(path="/")
    public @ResponseBody Iterable<Message> getMessages(int id_user) {
        return msgRepository.findAllByRecipient(id_user);
    }
}
