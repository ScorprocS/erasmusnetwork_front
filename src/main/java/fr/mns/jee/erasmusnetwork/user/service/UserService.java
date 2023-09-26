package fr.mns.jee.erasmusnetwork.user.service;

import fr.mns.jee.erasmusnetwork.user.client.UserRestClient;
import fr.mns.jee.erasmusnetwork.user.dto.GetUserByEmailRequest;
import fr.mns.jee.erasmusnetwork.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRestClient userRestClient;

    public Optional<User> getUserByEmail(String email){
        return userRestClient.getUserByEmail(new GetUserByEmailRequest(email));
    }

    public List<User> getUsers(){
        return userRestClient.getUsers();
    }
}
