package fr.mns.jee.erasmusnetwork.forum.model;

import java.util.Date;

public class Post {
    private Long id;
    private String content;
    private User author;
    private Date createdOn;
    private Date lastUpdated;

    public void Address(Long id, String content, User author, Date createdOn, Date lastUpdated) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.createdOn = createdOn;
        this.lastUpdated = lastUpdated;
    }

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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}