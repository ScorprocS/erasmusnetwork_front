package fr.mns.jee.erasmusnetwork.message.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Group implements Serializable {
    private Long id;

    private String name;

    private Date createdAt;

    private Set<Message> messages;

    private Set<Member> members;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Set<Member> getMembers() {
        return members;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }

    public Set<Message> getMessages() {
        if(messages == null)
            return Set.of();

        return messages.stream().sorted((m1, m2) -> m1.getCreatedAt().compareTo(m2.getCreatedAt())).collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public Message getLastMessage() {
        if(messages == null)
            return null;

        return messages.stream().min((m1, m2) -> m2.getCreatedAt().compareTo(m1.getCreatedAt())).orElse(null);
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }
}
