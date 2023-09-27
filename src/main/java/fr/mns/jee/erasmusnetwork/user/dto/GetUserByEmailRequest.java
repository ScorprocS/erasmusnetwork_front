package fr.mns.jee.erasmusnetwork.user.dto;

import java.io.Serializable;

public class GetUserByEmailRequest implements Serializable {
    private String email;

    public GetUserByEmailRequest(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
