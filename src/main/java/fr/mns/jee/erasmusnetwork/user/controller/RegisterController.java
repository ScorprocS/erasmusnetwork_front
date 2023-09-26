package fr.mns.jee.erasmusnetwork.user.controller;

import fr.mns.jee.erasmusnetwork.user.dto.CreateUserRequest;
import fr.mns.jee.erasmusnetwork.user.model.User;
import fr.mns.jee.erasmusnetwork.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    ModelAndView register(){
        ModelAndView mv = new ModelAndView("users/register");
        return mv;
    }

    @PostMapping
    ModelAndView signUpSubmit(@ModelAttribute CreateUserRequest createUserRequest){
        createUserRequest.password = passwordEncoder.encode(createUserRequest.password);
        User user = userService.createUser(createUserRequest.email, createUserRequest.password);
        ModelAndView mv = register();
        mv.addObject("userCreated", user);
        return mv;
    }
}
