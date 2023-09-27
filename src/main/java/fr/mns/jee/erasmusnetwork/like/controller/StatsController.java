package fr.mns.jee.erasmusnetwork.like.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.mns.jee.erasmusnetwork.like.LikeRestClient;

@Controller
@RequestMapping("/stats")
public class StatsController {
	
	@Autowired
	private LikeRestClient client;

	@GetMapping("")
	public ModelAndView getStats() {
		ModelAndView mv = new ModelAndView("like/stats");
		return mv;
	}

	@GetMapping("/comment")
	public String getCommentStats(Model model) {
		model.addAttribute("comments", client.findAllComments());
		return "like/stats";
	}
	
	@GetMapping("/commentByUser")
	public String getCommentsByUserId(Model model, @RequestParam(name = "userId") int userId) {
		model.addAttribute("comments", client.findAllComments());
		model.addAttribute("userLikedComments", client.findCommentByUserId(userId));
		return "like/stats";
	}
	
	@GetMapping("/post")
	public String getPostStats(Model model) {
		model.addAttribute("posts", client.findAllPosts());
		return "like/stats";
	}
	
	@GetMapping("/postByUser")
	public String getPostsByUserId(Model model, @RequestParam(name = "userId") int userId) {
		model.addAttribute("posts", client.findAllPosts());
		model.addAttribute("userLikedPosts", client.findPostByUserId(userId));
		return "like/stats";
	}
	
	@GetMapping("/user")
	public String getUserStats(Model model) {
		model.addAttribute("users", client.findAllUsers());
		return "like/stats";
	}
	
	@GetMapping("/userByUser")
	public String getUsersByUserId(Model model, @RequestParam(name = "userId") int userId) {
		model.addAttribute("users", client.findAllUsers());
		model.addAttribute("userLikedUsers", client.findUserByUserId(userId));
		return "like/stats";
	}
	
}