package fr.mns.jee.erasmusnetwork.message.controller;

import fr.mns.jee.erasmusnetwork.message.model.Group;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class NavigationController {

	@GetMapping(value = "/message")
	public String getMessage(Model model) {
		String uri = "http://localhost:8086/api/groups/";
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<Group[]> responseEntity = restTemplate.getForEntity(uri, Group[].class);
		Group[] groups = responseEntity.getBody();

		for (Group group : groups) {
			System.out.println(group.name);
		}

		model.addAttribute("groups", groups);

		return "message/message";
	}
}
