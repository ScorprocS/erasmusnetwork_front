package fr.mns.jee.erasmusnetwork.contact.controller;

import fr.mns.jee.erasmusnetwork.contact.service.ContactService;
import fr.mns.jee.erasmusnetwork.contact.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        List<Contact> contacts;

        if (searchTerm != null && searchTerm.length() > 2) {
            contacts = contactService.searchContacts(searchTerm);
        } else {
            contacts = contactService.getAllContacts();
        }

        model.addAttribute("contacts", contacts);
        model.addAttribute("searchTerm", searchTerm);

        return "contacts";
    }
}
