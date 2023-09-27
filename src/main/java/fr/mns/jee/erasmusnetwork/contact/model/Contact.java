package fr.mns.jee.erasmusnetwork.contact.model;

import com.fasterxml.jackson.annotation.JsonFormat;

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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setOriginCountry(String origin_country) {
        this.origin_country = origin_country;
    }

    public void setLivingCountry(String living_country) {
        this.living_country = living_country;
    }

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
