package fr.mns.jee.erasmusnetwork.annonce.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/collocation")
@PreAuthorize("isAuthenticated()")
public class CollocationController {


    @GetMapping
    public ModelAndView getCollocation() {
        ModelAndView mv = new ModelAndView("Annonce/annonce");
        return mv;
    }

    @GetMapping("/{id}")
    public ModelAndView getCollocationById(@PathVariable("id") Long id) {

        ModelAndView mv = new ModelAndView("Annonce/details");
        return mv;

    }
}