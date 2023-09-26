package fr.mns.jee.erasmusnetwork.message.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {

	@GetMapping("/message")
	public String getMessages() {
		return "message/message";
	} 
}
