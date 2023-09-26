package fr.mns.jee.erasmusnetwork.annonce.controller;


import fr.mns.jee.erasmusnetwork.annonce.model.Bed;
import fr.mns.jee.erasmusnetwork.annonce.model.House;
import fr.mns.jee.erasmusnetwork.annonce.service.ApiService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/collocation")
public class CollocationController {

    private final ApiService apiService;

    public CollocationController(ApiService apiService) {
        this.apiService = apiService;
    }


    @GetMapping({"", "/"})
    public ModelAndView getCollocation() {

        House[] houses = apiService.getHouses();

        ModelAndView mv = new ModelAndView("Annonce/annonce");

        mv.addObject("houses", houses);
        return mv;
    }

    @GetMapping("/{id}")
    public ModelAndView getCollocationById(@PathVariable("id") String id) {
        House house = apiService.getHouseWithId(id);

        ModelAndView mv = new ModelAndView("Annonce/details");
        mv.addObject("house", house);

        List<Integer> availableQuantity = new ArrayList<>();
        for (int i = 1; i <= house.bedAvailable(); i++) {
            availableQuantity.add(i);
        }
        mv.addObject("availableQuantity", availableQuantity);
        return mv;
    }
}