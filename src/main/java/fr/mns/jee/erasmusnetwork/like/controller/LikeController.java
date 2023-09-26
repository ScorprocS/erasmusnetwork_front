package fr.mns.jee.erasmusnetwork.like.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.mns.jee.erasmusnetwork.like.LikeRestClient;
import fr.mns.jee.erasmusnetwork.like.struct.LikedCommentStruct;

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
	
	@GetMapping("/comment")
	public ModelAndView getCommentStats() {
		ModelAndView mv = new ModelAndView("like/commentStats");
		mv.addObject("comments", client.findAllComments());
		return mv;
	}
	
	@PostMapping("/commentByUser")
	public List<LikedCommentStruct> getCommentsByUserId(@RequestParam int userId) {
		return client.findById(userId);
	}
}