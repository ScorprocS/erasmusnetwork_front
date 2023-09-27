package fr.mns.jee.erasmusnetwork.message.service;

import fr.mns.jee.erasmusnetwork.message.model.Member;
import fr.mns.jee.erasmusnetwork.user.model.User;
import fr.mns.jee.erasmusnetwork.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    UserService userService;

    @Autowired
    MemberAPIService memberAPIService;

    public Member getCurrentMember(){
        User user = userService.getCurrentUser();

        Member member = memberAPIService.getByUserId(user.getId());

        if(member == null){
            memberAPIService.createMember(user.getEmail(), user.getId());

            member = memberAPIService.getByUserId(user.getId());
        }

        return member;
    }
}
