package fr.mns.jee.erasmusnetwork.annonce.service;

import fr.mns.jee.erasmusnetwork.annonce.form.BookForm;
import fr.mns.jee.erasmusnetwork.annonce.model.House;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
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

    public House postHouse(House house) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<House> httpEntity = new HttpEntity<>(house, headers);

        House newHouse = restTemplate.postForObject("http://localhost:8083/house/add", httpEntity, House.class);

        return newHouse;
    }

    public BookForm postBook(String id, BookForm bookForm) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<BookForm> httpEntity = new HttpEntity<>(bookForm, headers);

        BookForm newBook = restTemplate.postForObject("http://localhost:8083/house/" + id + "/book", httpEntity, BookForm.class);

        return newBook;
    }
}

