package kea.sem3.jwtdemo.service;

import kea.sem3.jwtdemo.dto.UserResponse;
import kea.sem3.jwtdemo.entity.User;
import kea.sem3.jwtdemo.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class AuthService {

    UserRepository userRepository;
    User user;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserResponse login(String email , String password) {
        user = userRepository.findByEmail(email);
        if (user == null) {
            return null; //User not found, no reason to check further
        }
        user.setLoggedIn(false); //makes sure that the user is logged out
        if (!user.getPassword().equals(password)) {
            return null; //Password from db does not match password given by user
        }
        user.setLoggedIn(true);
        return new UserResponse(user);
    }

    public boolean notLoggedIn(HttpSession session) {
        return session.getAttribute("user") == null;
    }

}

