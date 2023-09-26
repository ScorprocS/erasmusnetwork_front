package fr.mns.jee.erasmusnetwork.annonce.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record House(Integer id, String name, String bed, Integer bedAvailable, List<Bed> beds) {
}