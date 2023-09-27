package fr.mns.jee.erasmusnetwork.contact.controller;

import fr.mns.jee.erasmusnetwork.contact.service.ContactService;
import fr.mns.jee.erasmusnetwork.contact.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;

@Controller
public class ContactController {
    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contacts")
    public String listContacts(Model model, @RequestParam(required = false) String searchTerm) {
        ResponseEntity<Object> response;

        if (searchTerm != null && searchTerm.length() > 2) {
            response = contactService.searchContacts(searchTerm);
        } else {
            response = contactService.getAllContacts();
        }

        LinkedHashMap hashMap = (LinkedHashMap) response.getBody();
        List<Contact> contacts = (List<Contact>) hashMap.get("data");

        model.addAttribute("contacts", contacts);
        model.addAttribute("searchTerm", searchTerm);

        return "contacts";
    }

    @PostMapping("/createContact")
    public String createContact(
            @RequestParam String firstname,
            @RequestParam String lastname,
            @RequestParam String gender,
            @RequestParam String email,
            @RequestParam String phone,
            @RequestParam String birthdate,
            @RequestParam String origin_country,
            @RequestParam String living_country) {
        Contact newContact = new Contact();
        newContact.setFirstname(firstname);
        newContact.setLastname(lastname);
        newContact.setGender(gender);
        newContact.setEmail(email);
        newContact.setPhone(phone);
        newContact.setBirthdate(birthdate);
        newContact.setOriginCountry(origin_country);
        newContact.setLivingCountry(living_country);

        contactService.createContact(newContact);

        return "redirect:/contacts";
    }

    @GetMapping("/deleteContact/{id}")
    public String deleteContact(@PathVariable Integer id) {
        contactService.deleteContact(id);

        return "redirect:/contacts";
    }
}
