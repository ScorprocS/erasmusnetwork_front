package fr.mns.jee.erasmusnetwork.message.model;

import java.io.Serializable;

public class Group implements Serializable {
    public Integer id;
    public String name;
    public String created_at;

    public Integer id() {
        return id;
    }
    public String name() {return name; }
    public String created_at() { return created_at;}
}