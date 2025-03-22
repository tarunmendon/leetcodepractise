package com.example.demo.service.caching;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/test")
    public String testEndpoint() {
        return "User test endpoint";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping("/{id}/{name}")
    public String addUser(@PathVariable int id, @PathVariable String name) {
        return userService.addUser(id, name);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}

