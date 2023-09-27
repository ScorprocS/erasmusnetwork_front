package fr.mns.jee.erasmusnetwork.controller.controller;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.mns.jee.erasmusnetwork.controller.model.User;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final String filePath = "users.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/search")
    public List<User> searchUsers(
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String program,
            @RequestParam(required = false) String university
    ) throws IOException {
        List<User> users = getUsersFromFile();

        if (location != null) {
            users = users.stream().filter(user -> location.equals(user.getLocation())).collect(Collectors.toList());
        }
        if (program != null) {
            users = users.stream().filter(user -> program.equals(user.getProgram())).collect(Collectors.toList());
        }
        if (university != null) {
            users = users.stream().filter(user -> university.equals(user.getUniversity())).collect(Collectors.toList());
        }

        return users;
    }

    private List<User> getUsersFromFile() throws IOException {
        File file = new File(filePath);
        if (file.exists()) {
            return objectMapper.readValue(file, new TypeReference<>() {});
        }
        return new ArrayList<>();
    }
}
