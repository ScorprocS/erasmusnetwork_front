package fr.mns.jee.erasmusnetwork.search.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "search/index";
    }
    @GetMapping("/search")
    public String searchUser() {
        return "search/searchUser";
    }
}
