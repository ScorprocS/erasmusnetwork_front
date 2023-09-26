package fr.mns.jee.erasmusnetwork.like.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.mns.jee.erasmusnetwork.like.LikeRestClient;

@Controller
@RequestMapping("/stats")
public class LikeController {
	
	@Autowired
	LikeRestClient likeRestclient;

	@GetMapping("")
	public ModelAndView getStats() {
		ModelAndView mv = new ModelAndView("like/stats");
		return mv;
	}
	

	@GetMapping("/users")
	public ModelAndView getStatsUsers() {
		ModelAndView mv = new ModelAndView("like/users");
		mv.addObject("usersList",likeRestclient.getUsersList());
		return mv;
	}
}