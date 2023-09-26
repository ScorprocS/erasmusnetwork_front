package fr.mns.jee.erasmusnetwork.contact.model;

import java.io.Serializable;

public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String firstname;
    private String lastname;
    private String gender;
    private String birthdate;
    private String email;
    private String phone;
    private String origin_country;
    private String living_country;

    public Contact() {}

    public Integer getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getGender() {
        return gender;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getOrigin_country() {
        return origin_country;
    }

    public String getLiving_country() {
        return living_country;
    }
}
