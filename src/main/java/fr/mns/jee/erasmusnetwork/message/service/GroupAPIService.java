package fr.mns.jee.erasmusnetwork.message.service;

import fr.mns.jee.erasmusnetwork.message.model.Group;
import fr.mns.jee.erasmusnetwork.message.model.Member;
import fr.mns.jee.erasmusnetwork.message.model.Message;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GroupAPIService extends AbstractApiService {
    public Group getById(Long id) {
        return (Group) query("groups/" + id, Group.class).getBody();
    }
    public Group[] getAllByMemberId(Long id) {
        return (Group[]) query("members/" + id + "/groups", Group[].class).getBody();
    }

    private boolean create(Group group) {
        return create("groups/", group);
    }

    public boolean createGroup(Set<Member> members, String groupName) {
        Group group = new Group();

        group.setName(groupName);
        group.setMembers(members);

        return create(group);
    }
}
