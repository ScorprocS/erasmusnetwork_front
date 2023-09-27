package fr.mns.jee.erasmusnetwork.user.client;

import fr.mns.jee.erasmusnetwork.user.dto.CreateUserRequest;
import fr.mns.jee.erasmusnetwork.user.dto.GetUserByEmailRequest;
import fr.mns.jee.erasmusnetwork.user.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@FeignClient(value = "userClient", url = "http://localhost:8084/users")
public interface UserRestClient {

    @GetMapping(value = "/")
    List<User> getUsers();

    @GetMapping(value = "/{userId}", produces = "application/json")
    User getUserById(@PathVariable("userId") Long userId);

    @DeleteMapping(value = "/{userId}")
    void deleteUser(@PathVariable("userId") Long userId);

    @PostMapping(value = "/")
    User createUser(@RequestBody CreateUserRequest request);

    @GetMapping(value = "/getByEmail")
    User getUserByEmail(@RequestParam(name = "email") String email);

    @PutMapping(value = "/{userId}/enable")
    User enableUser(@PathVariable("userId") Long userId);

    @PutMapping(value = "/{userId}/disable")
    User disableUser(@PathVariable("userId") Long userId);

//    @GetMapping(value = "/getCurrentUser")
//    User getCurrentUser();
}
