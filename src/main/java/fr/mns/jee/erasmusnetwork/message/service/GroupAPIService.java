package fr.mns.jee.erasmusnetwork.message.service;

import fr.mns.jee.erasmusnetwork.message.model.Group;
import org.springframework.stereotype.Service;

@Service
public class GroupAPIService extends AbstractApiService {
    public Group getById(Long id) {
        return (Group) query("groups/" + id, Group.class).getBody();
    }
}
