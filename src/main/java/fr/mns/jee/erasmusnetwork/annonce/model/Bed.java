package fr.mns.jee.erasmusnetwork.annonce.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Bed(Integer id, String userId) { }