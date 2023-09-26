package fr.mns.jee.erasmusnetwork.annonce.service;

import fr.mns.jee.erasmusnetwork.annonce.model.House;
import org.springframework.web.client.RestTemplate;

import org.springframework.stereotype.Service;

@Service
public class ApiService {
    private final String apiUrl;

    public ApiService() {
        this.apiUrl = "localhost:8083/house";
    }

    public House[] getHouses() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(
                "http://localhost:8083/house/", House[].class);
    }

    public House getHouseWithId(String id) {
        RestTemplate restTemplate = new RestTemplate();
        House house = restTemplate.getForObject(
                "http://localhost:8083/house/" + id, House.class);
        return house;
    }
}

