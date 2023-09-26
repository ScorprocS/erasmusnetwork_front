package fr.mns.jee.erasmusnetwork.message.service;

import fr.mns.jee.erasmusnetwork.message.model.Member;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class MemberAPIService extends AbstractApiService {
    public Member getById(Long id) {
        return (Member) query("members/" + id, Member.class).getBody();
    }
}
