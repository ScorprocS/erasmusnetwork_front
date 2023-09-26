package fr.mns.jee.erasmusnetwork.user.dto;

public class CreateUserRequest {
    public String email;
    public String password;

    public CreateUserRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
