package fr.mns.jee.erasmusnetwork.like.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/stats")
public class LikeController {

	@GetMapping("/")
	public ModelAndView getPersons() {
		ModelAndView mv = new ModelAndView("like/stats");
		return mv;
	}
}