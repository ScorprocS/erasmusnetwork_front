package fr.mns.jee.erasmusnetwork.annonce.form;

import fr.mns.jee.erasmusnetwork.annonce.model.Bed;

import java.util.List;

public class HouseForm {

    private String name;
    private String description;
    private Integer bed;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getBed() {
        return bed;
    }

    public void setBed(Integer bed) {
        this.bed = bed;
    }
}
