package fr.mns.jee.erasmusnetwork.message.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Message implements Serializable {

    private Long id;

    private String content;

    private Date createdAt;

    private Group group;

    private Message parent;

    private Member sender;

    private Long senderId;

    private Set<MemberMessageView> views = new HashSet<MemberMessageView>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Message getParent() {
        return parent;
    }

    public void setParent(Message parent) {
        this.parent = parent;
    }

    public Member getSender() {
        return sender;
    }

    public void setSender(Member sender) {
        this.sender = sender;
    }

    public Set<MemberMessageView> getViews() {
        return views;
    }

    public void setViews(Set<MemberMessageView> views) {
        this.views = views;
    }

    public Optional<Long> getSenderId() {
        if (senderId == null) {
            return Optional.empty();
        }
        return Optional.of(senderId);
    }
}
