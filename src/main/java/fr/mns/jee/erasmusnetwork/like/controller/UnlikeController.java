package fr.mns.jee.erasmusnetwork.like.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.mns.jee.erasmusnetwork.like.LikeRestClient;
import fr.mns.jee.erasmusnetwork.like.struct.LikedCommentStruct;
import fr.mns.jee.erasmusnetwork.like.struct.LikedPostStruct;
import fr.mns.jee.erasmusnetwork.like.struct.LikedUserStruct;

@Controller
@RequestMapping("/unlike")
public class UnlikeController {
	@Autowired
	private LikeRestClient client;

	@PostMapping("/comment")
	public String likeComment(@RequestBody LikedCommentStruct commentStruct) {
		client.likeComment(commentStruct);

		// TODO redirection
		return "";
	}
	@PostMapping("/post")
	public String likePost(@RequestBody LikedPostStruct postStruct) {
		client.likePost(postStruct);

		// TODO redirection
		return "";
	}
	@PostMapping("/user")
	public String likeUser(@RequestBody LikedUserStruct userStruct) {
		client.likeUser(userStruct);

		// TODO redirection
		return "";
	}
}
