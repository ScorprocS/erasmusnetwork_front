package fr.mns.jee.erasmusnetwork.message.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.mns.jee.erasmusnetwork.message.model.User;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.http.ResponseEntity;
import fr.mns.jee.erasmusnetwork.message.model.Group;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.client.RestTemplate;

@Controller
public class NavigationController {

	@GetMapping(value = "/message")
	public String getMessage(Model model) {
		String uri = "http://localhost:8086/api/groups/";
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Group[]> responseEntity = restTemplate.getForEntity(uri, Group[].class);
		Group[] groups = responseEntity.getBody();

		model.addAttribute("groups", groups);

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
