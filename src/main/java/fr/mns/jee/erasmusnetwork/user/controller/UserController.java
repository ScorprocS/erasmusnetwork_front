package fr.mns.jee.erasmusnetwork.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/users")
public class UserController {
    @RequestMapping(value = { "/", "/index"}, method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("message", "Test");
        return "index";
    }

}
