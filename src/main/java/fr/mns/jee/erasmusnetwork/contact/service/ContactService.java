package fr.mns.jee.erasmusnetwork.contact.service;

import fr.mns.jee.erasmusnetwork.contact.model.Contact;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "contact-api", url = "http://localhost:8081")
public interface ContactService {
    @GetMapping(value = "/api/contacts", produces = "application/json")
    ResponseEntity<Object> getAllContacts();

    @GetMapping(value = "/api/contacts/search/{searchTerm}", produces = "application/json")
    ResponseEntity<Object> searchContacts(@PathVariable String searchTerm);

    @PostMapping(value = "/api/contacts", produces = "application/json")
    ResponseEntity<Object> createContact(Contact newContact);

    @DeleteMapping(value = "/api/contacts/{id}")
    ResponseEntity<Object> deleteContact(@PathVariable Integer id);
}
