package fr.mns.jee.erasmusnetwork.annonce.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

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

    @GetMapping("/add")
    public ModelAndView getAddCollocation() {

        ModelAndView mv = new ModelAndView("Annonce/addCollocation");
        return mv;

    }

    //@PostMapping("/add")
    //public String createNewHouse(@ModelAttribute("houseForm") House house) {
//
    //    house.setId(null);
    //    house.setNomCollocation();
    //    house.setDescription();
    //    house.setNbrPlace();
    //    repository.save(person);
//
    //    return "redirect:/annonce";
//
    //}
}