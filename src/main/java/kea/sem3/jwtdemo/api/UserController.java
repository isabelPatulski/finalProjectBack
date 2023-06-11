package kea.sem3.jwtdemo.api;


import kea.sem3.jwtdemo.dto.UserRequest;
import kea.sem3.jwtdemo.dto.UserResponse;
import kea.sem3.jwtdemo.entity.User;
import kea.sem3.jwtdemo.repositories.UserRepository;
import kea.sem3.jwtdemo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/user")
public class UserController {


    UserService userService;
    UserRepository userRepository;

    public UserController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping
    List<User> getUsers() {
        return userRepository.findAll();}

    @GetMapping("/{email}")
    public UserResponse getUser(@PathVariable String email) throws Exception {
        return userService.getUser(email);
    }

    @GetMapping("/loggedIn")
    public boolean loggedIn() throws Exception {
        return UserService.isLoggedIn();
    }

    @PostMapping("/login")
    public UserResponse login(@RequestBody UserRequest body) {
        UserResponse user = userService.loginUser(body);
        if (UserService.isLoggedIn())
        {
            return user;
        }
        return null;
    }

    @PostMapping("/logout")
    public void logout() {
        UserService.logoutUser();
    }

    @PostMapping
    public UserResponse addUser(@RequestBody UserRequest body) {
        System.out.println("Received user request: " + body);
        return userService.addUser(body);}


    @PutMapping("/{email}")
    public UserResponse editUser(@RequestBody UserRequest body, @PathVariable String email){
        return userService.editUser(body, email);
    }

    @DeleteMapping("/{email}")
    public void deleteUser(@PathVariable String email){}
}