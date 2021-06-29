package com.acfaudit.conversation;

import java.util.List;

import com.acfaudit.model.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<Message, Integer> {
    List<Message> findAllByRecipient(int recipient_id);
}
