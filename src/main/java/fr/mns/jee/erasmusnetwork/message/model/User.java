package fr.mns.jee.erasmusnetwork.message.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private Long id;
    private Date createdAt;
    private String customName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }



    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }




}
