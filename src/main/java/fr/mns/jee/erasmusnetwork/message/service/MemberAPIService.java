package fr.mns.jee.erasmusnetwork.message.service;

import fr.mns.jee.erasmusnetwork.message.model.Group;
import fr.mns.jee.erasmusnetwork.message.model.Member;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Set;

@Service
public class MemberAPIService extends AbstractApiService {
    public Member getById(Long id) {
        return (Member) query("members/" + id, Member.class).getBody();
    }

    public Member[] getAll() {
        return (Member[]) query("members/", Member[].class).getBody();
    }

    public Member[] getMembersByGroup(Long id) { return (Member[]) query("groups/" + id + "/members", Member[].class).getBody();}

    public Member getByUserId(Long userId){
        return (Member) query("members/users/" + userId, Member.class).getBody();
    }

    private boolean create(Member member) {
        return create("members/", member);
    }

    public boolean createMember(String customName, Long userId) {
        Member member = new Member();

        member.setCustomName(customName);
        member.setUserId(userId);

        return create(member);
    }
}
