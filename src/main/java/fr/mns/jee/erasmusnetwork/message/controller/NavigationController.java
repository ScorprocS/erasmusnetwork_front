package fr.mns.jee.erasmusnetwork.message.controller;

import fr.mns.jee.erasmusnetwork.message.model.User;
import fr.mns.jee.erasmusnetwork.message.service.GroupAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import fr.mns.jee.erasmusnetwork.message.model.Group;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Set;

@Controller
public class NavigationController {

	@Autowired
	private GroupAPIService groupAPIService;

	@GetMapping(value = "/message")
	public String getMessage(Model model, @RequestParam(required = false, name = "group") Long groupId) {
		Long CurrentMemberId = 1L;
		Group[] groups = groupAPIService.getAllByMemberId(CurrentMemberId);
		model.addAttribute("groups", groups);
		model.addAttribute("CurrentMemberId", CurrentMemberId);

		if (groupId != null) {
			Group currentGroup = groupAPIService.getById(groupId);
			if (currentGroup != null) {
				model.addAttribute("currentGroup", currentGroup);
			}
		}

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
