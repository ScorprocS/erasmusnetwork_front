package fr.mns.jee.erasmusnetwork.user.client;

import feign.Param;
import feign.RequestLine;
import fr.mns.jee.erasmusnetwork.user.dto.CreateUserRequest;
import fr.mns.jee.erasmusnetwork.user.dto.GetUserByEmailRequest;
import fr.mns.jee.erasmusnetwork.user.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
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

//    @RequestMapping(method = RequestMethod.GET, value = "/getByEmail?email={email}")
//    @RequestLine("GET /getByEmail?email={email}")
    @PostMapping(value = "/getByEmail")
    User getUserByEmail(@RequestBody GetUserByEmailRequest request);

    @PutMapping(value = "/{userId}/enable")
    User enableUser(@PathVariable("userId") Long userId);

    @PutMapping(value = "/{userId}/disable")
    User disableUser(@PathVariable("userId") Long userId);

//    @GetMapping(value = "/getCurrentUser")
//    User getCurrentUser();
}
