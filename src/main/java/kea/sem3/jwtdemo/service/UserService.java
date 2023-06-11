package kea.sem3.jwtdemo.service;

import kea.sem3.jwtdemo.dto.UserRequest;
import kea.sem3.jwtdemo.dto.UserResponse;
import kea.sem3.jwtdemo.entity.User;
import kea.sem3.jwtdemo.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponse> getUsers(){
        List<User> users =  userRepository.findAll();
        return UserResponse.getUsersFromEntities(users);
    }
    public UserResponse getUser(String email) throws Exception {
        User user = userRepository.findByEmail(email);
        return new UserResponse(user);
    }


    public UserResponse addUser(UserRequest body){
        User newUser = userRepository.save(new User(body));
        return new UserResponse(newUser);
    }

    public UserResponse editUser(UserRequest userToEdit, String email){
        User user = userRepository.findByEmail(email);
        user.setEmail(userToEdit.getEmail());
        return new UserResponse(userRepository.save(user));
    }

    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }
}

