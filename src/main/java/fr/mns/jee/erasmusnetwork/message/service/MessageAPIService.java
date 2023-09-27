package fr.mns.jee.erasmusnetwork.message.service;

import fr.mns.jee.erasmusnetwork.message.model.Group;
import fr.mns.jee.erasmusnetwork.message.model.Member;
import fr.mns.jee.erasmusnetwork.message.model.Message;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MessageAPIService extends AbstractApiService {
    public Message getById(Long id) {
        return (Message) query("messages/" + id, Message.class).getBody();
    }

    private boolean create(Message message) {
        return create("messages/", message);
    }

    public boolean createMessage(Long groupId, String content, Long senderId) {
        Message message = new Message();
        Group group = new Group();
        Member sender = new Member();
        sender.setId(senderId);
        group.setId(groupId);
        group.setMessages(Set.of());
        message.setGroup(group);
        message.setContent(content);
        message.setSender(sender);
        return create(message);
    }
}
