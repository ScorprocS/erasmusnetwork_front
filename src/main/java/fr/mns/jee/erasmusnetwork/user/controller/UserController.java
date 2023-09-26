package fr.mns.jee.erasmusnetwork.user.controller;

import fr.mns.jee.erasmusnetwork.user.model.User;
import fr.mns.jee.erasmusnetwork.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ModelAndView listUsers(){
        ModelAndView mv = new ModelAndView("users/users");
        List<User> usersList = userService.getUsers();
        for (User user: usersList) {
            mv.addObject("usersListElement", user);
        }
        return mv;
    }
}
