package fr.mns.jee.erasmusnetwork.like.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.mns.jee.erasmusnetwork.like.LikeRestClient;

@Controller
@RequestMapping("/like")
public class LikeController {

	@Autowired
	private LikeRestClient client;

	@PostMapping("/comment")
	public String likeComment(@RequestParam(name = "likeId") int likeId) {
		client.unlikeComment(likeId);

		// TODO redirection
		return "";
	}
	@PostMapping("/post")
	public String likePost(@RequestParam(name = "likeId") int likeId) {
		client.unlikePost(likeId);

		// TODO redirection
		return "";
	}
	@PostMapping("/user")
	public String likeUser(@RequestParam(name = "likeId") int likeId) {
		client.unlikeUser(likeId);

		// TODO redirection
		return "";
	}
}
