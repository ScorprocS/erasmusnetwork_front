package fr.mns.jee.erasmusnetwork.search.controller;

import fr.mns.jee.erasmusnetwork.controller.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final WebClient webClient;

    public UserController(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8085").build();
    }

    @GetMapping("/searchUsers")
    public Mono<List<User>> searchUsers(
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String program,
            @RequestParam(required = false) String university,
            @RequestParam(required = false) String country
    ) {
        logger.info("Début de la méthode searchUsers");
        logger.info("Location: " + location);
        logger.info("Program: " + program);
        logger.info("University: " + university);
        logger.info("University: " + country);

        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/users/searchUsers")
                        .queryParamIfPresent("location", Optional.ofNullable(location))
                        .queryParamIfPresent("program", Optional.ofNullable(program))
                        .queryParamIfPresent("university", Optional.ofNullable(university))
                        .queryParamIfPresent("university", Optional.ofNullable(country))
                        .build())
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<User>>() {})
                .doOnNext(users -> logger.info("Users found: " + users.size()))
                .doOnError(throwable -> logger.error("Error occurred while fetching users", throwable));
    }
}
