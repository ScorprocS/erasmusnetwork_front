package fr.mns.jee.erasmusnetwork.like.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.mns.jee.erasmusnetwork.like.LikeRestClient;

@Controller
@RequestMapping("/stats")
public class LikeController {
	
	@Autowired
	private LikeRestClient client;

	@GetMapping("")
	public ModelAndView getStats() {
		ModelAndView mv = new ModelAndView("like/stats");
		return mv;
	}

	
	
	@GetMapping("/users")
	public ModelAndView getStatsUsers() {
		ModelAndView mv = new ModelAndView("like/users");
		mv.addObject("usersList",client.getUsersList());
		return mv;
	}
	
	@GetMapping("/usersByUser/{userId}")
	public ModelAndView getUsersByUserId(@PathVariable int userId){
		ModelAndView mv = new ModelAndView("like/usersByUser");
		mv.addObject("usersList",client.getUsersById(userId));
		return mv;
	}
	
	
	

	@GetMapping("/comment")
	public String getCommentStats(Model model) {
		model.addAttribute("comments", client.findAllComments());
		return "like/stats";
	}
	
	@GetMapping("/commentByUser")
	public String getCommentsByUserId(Model model, @RequestParam(name = "userId") int userId) {
		model.addAttribute("userLikedComments", client.findById(userId));
		return "like/stats";
	}
}