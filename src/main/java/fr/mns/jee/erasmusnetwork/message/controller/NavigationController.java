package fr.mns.jee.erasmusnetwork.message.controller;

import fr.mns.jee.erasmusnetwork.message.model.Member;
import fr.mns.jee.erasmusnetwork.message.model.User;
import fr.mns.jee.erasmusnetwork.message.model.Member;
import fr.mns.jee.erasmusnetwork.message.service.GroupAPIService;
import fr.mns.jee.erasmusnetwork.message.service.MemberAPIService;
import fr.mns.jee.erasmusnetwork.message.service.MessageAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import fr.mns.jee.erasmusnetwork.message.model.Group;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.*;

import static java.lang.Long.parseLong;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class NavigationController {

	@Autowired
	private GroupAPIService groupAPIService;

	@Autowired
	private MessageAPIService messageAPIService;

	@Autowired
	private MemberAPIService memberAPIService;

	@GetMapping(value = "/chats")
	public String getMessage(
			Model model,
			@RequestParam(required = false, name = "group") Long groupId,
			@RequestParam(required = false, name = "new") Boolean newChat
	) {
		Long CurrentMemberId = 1L;
		Group[] groups = groupAPIService.getAllByMemberId(CurrentMemberId);
		model.addAttribute("groups", groups);
		model.addAttribute("CurrentMemberId", CurrentMemberId);

		if (groupId != null) {
			Group currentGroup = groupAPIService.getById(groupId);
			if (currentGroup != null) {
				model.addAttribute("currentGroup", currentGroup);
				Member[] members = memberAPIService.getMembersByGroup(currentGroup.getId());
				String membersList = Arrays.stream(members).map(Member::getCustomName).collect(Collectors.joining(", "));
				model.addAttribute("membersList", membersList);
			}
		}

		if (newChat != null) {
			model.addAttribute("newChat", true);

			Member[] members = memberAPIService.getAll();

			model.addAttribute("members", members);
		}

		return "chats/index";
	}

	@PostMapping(value = "/chats")
	public String postMessage(
			Model model,
		  	@RequestParam(required = false, name = "group") Long groupId,
			@RequestParam(required = false, name = "message") String message,
			@RequestParam(required = false, name= "members") String[] membersIds,
			@RequestParam(required = false, name= "groupName") String groupName
	) {
		Long CurrentMemberId = 1L;

		if (groupId != null && message != null) {
			messageAPIService.createMessage(groupId, message, CurrentMemberId);
		}

		if (membersIds != null) {
			Set<Member> members = new HashSet<Member>();

			for(String memberId: membersIds){
				Member member = new Member();

				member.setId(parseLong(memberId));

				members.add(member);
			}

			Member member = new Member();

			member.setId(1L);

			members.add(member);

			if(groupName == null || groupName.isEmpty()){
				groupName = "Chat";
			}

			groupAPIService.createGroup(members, groupName);
		}

		if (groupId != null) {
			return "redirect:/chats?group=" + groupId;
		}

		return "redirect:/chats?group=1";
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

		return "chats/test-user";
	}
}
