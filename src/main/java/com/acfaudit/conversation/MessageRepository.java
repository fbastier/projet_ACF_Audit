package com.acfaudit.conversation;

import com.acfaudit.model.Client;
import com.acfaudit.model.Message;
import org.springframework.data.repository.CrudRepository;


public interface MessageRepository extends CrudRepository<Message, Integer> {
}
