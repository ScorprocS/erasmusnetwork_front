package fr.mns.jee.erasmusnetwork.user.service;

import fr.mns.jee.erasmusnetwork.user.client.UserRestClient;
import fr.mns.jee.erasmusnetwork.user.dto.CreateUserRequest;
import fr.mns.jee.erasmusnetwork.user.dto.GetUserByEmailRequest;
import fr.mns.jee.erasmusnetwork.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRestClient userRestClient;

    public Optional<User> getUserByEmail(String email){
        return userRestClient.getUserByEmail(new GetUserByEmailRequest(email));
    }

    public User getUserById(Long userId){
        return userRestClient.getUserById(userId);
    }

    public List<User> getUsers(){
        return userRestClient.getUsers();
    }

    public User enableUser(Long userId){
        return userRestClient.enableUser(userId);
    }

    public User disableUser(Long userId){
        return userRestClient.disableUser(userId);
    }

    public User createUser(String email,String password){
        return userRestClient.createUser(new CreateUserRequest(email,password));
    }

    public void deleteUser(Long userId){
       userRestClient.deleteUser(userId);
    }

//    public User getCurrentUser(Principal principal){
//        return userRestClient.getCurrentUser();
//    }
    public User getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return getUsers().stream().filter(u -> u.getUsername() == authentication.getName()).findFirst().orElseThrow();
    }
}
