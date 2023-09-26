package fr.mns.jee.erasmusnetwork.message.service;

import fr.mns.jee.erasmusnetwork.message.model.Group;
import fr.mns.jee.erasmusnetwork.message.model.Message;
import org.springframework.stereotype.Service;

@Service
public class MessageAPIService extends AbstractApiService {
    public Message getById(Long id) {
        return (Message) query("messages/" + id, Message.class).getBody();
    }
}
