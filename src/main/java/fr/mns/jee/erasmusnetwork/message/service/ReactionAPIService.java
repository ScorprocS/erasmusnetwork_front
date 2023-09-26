package fr.mns.jee.erasmusnetwork.message.service;

import fr.mns.jee.erasmusnetwork.message.model.Message;
import fr.mns.jee.erasmusnetwork.message.model.Reaction;
import org.springframework.stereotype.Service;

@Service
public class ReactionAPIService extends AbstractApiService {
    public Reaction getById(Long id) {
        return (Reaction) query("reactions/" + id, Reaction.class).getBody();
    }
}
