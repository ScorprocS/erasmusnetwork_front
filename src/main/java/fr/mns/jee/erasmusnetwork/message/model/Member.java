package fr.mns.jee.erasmusnetwork.message.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Member implements Serializable {
    private Long id;

    private String customName;

    private Set<Group> groups;

    private Long userId;

    private Set<MemberMessageView> membersViews = new HashSet<MemberMessageView>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
