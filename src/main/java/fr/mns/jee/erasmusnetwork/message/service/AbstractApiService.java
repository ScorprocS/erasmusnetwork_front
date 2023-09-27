package fr.mns.jee.erasmusnetwork.message.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public abstract class AbstractApiService {
    final String baseUrl = "http://localhost:8086/api/";

    public ResponseEntity<?> query(String uri, Class<?> clazz) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(baseUrl + uri, clazz);
    }

    public boolean create(String uri, Object object) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<?> responseEntity = restTemplate.postForEntity(baseUrl + uri, object, Object.class);
        return responseEntity.getStatusCode().is2xxSuccessful();
    }
}
