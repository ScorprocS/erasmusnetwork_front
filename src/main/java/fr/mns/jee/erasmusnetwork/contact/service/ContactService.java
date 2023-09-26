package fr.mns.jee.erasmusnetwork.contact.service;

import fr.mns.jee.erasmusnetwork.contact.model.Contact;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "contact-api", url = "http://localhost:8081")
public interface ContactService {
    @GetMapping("/api/contacts")
    List<Contact> getAllContacts();

    @GetMapping("/api/contacts/search")
    List<Contact> searchContacts(@RequestParam("searchTerm") String searchTerm);
}

