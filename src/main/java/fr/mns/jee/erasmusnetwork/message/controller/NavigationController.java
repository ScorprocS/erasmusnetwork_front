package fr.mns.jee.erasmusnetwork.message.controller;

import fr.mns.jee.erasmusnetwork.message.model.User;
import fr.mns.jee.erasmusnetwork.message.service.GroupAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import fr.mns.jee.erasmusnetwork.message.model.Group;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class NavigationController {

	@Autowired
	private GroupAPIService groupAPIService;

	@GetMapping(value = "/message")
	public String getMessage(Model model) {

		model.addAttribute("groups", groupAPIService.getAllByMemberId(1L));

		return "message/index";
	} 


	@GetMapping("/test")
	public String getUsers(Model model) {
		String uri = "http://localhost:8086/api/members/1";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<User> responseEntity =
				restTemplate.getForEntity(uri, User.class);
		User user = responseEntity.getBody();
		System.out.println(user.getCustomName());

		model.addAttribute("user", user);

		return "message/test-user";
	}
}
