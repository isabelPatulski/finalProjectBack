package kea.sem3.finalProject.service;

import kea.sem3.finalProject.dto.UserRequest;
import kea.sem3.finalProject.dto.UserResponse;
import kea.sem3.finalProject.entity.User;
import kea.sem3.finalProject.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    UserRepository userRepository;
    public static User  currentUser;    // Current logged in user, if any

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponse> getUsers(){
        List<User> users =  userRepository.findAll();
        return UserResponse.getUsersFromEntities(users);
    }
    public UserResponse getUser(String email) throws Exception {
        User user = userRepository.findByEmail(email);//.orElseThrow(()->new Client4xxException("No user with this email exists"));
        return new UserResponse(user);
    }


    public UserResponse addUser(UserRequest body){
        User newUser = userRepository.save(new User(body));
        return new UserResponse(newUser);
    }

    public UserResponse editUser(UserRequest userToEdit, String email){
        User user = userRepository.findByEmail(email);//orElseThrow(()-> new Client4xxException("No user with provided ID found"));
        user.setEmail(userToEdit.getEmail());
        return new UserResponse(userRepository.save(user));
    }

    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }

    public static void logoutUser() {
        currentUser =  null;
    }
    public UserResponse loginUser(UserRequest body) {
        User user = userRepository.findByEmail(body.getEmail());
        if (user.getPassword().equals(body.getPassword()))
        {
            user.setLoggedIn(true);
            currentUser =  user;
        }
        else
        {
            user.setLoggedIn(false);
            currentUser =  null;
        }
        return new UserResponse(currentUser);
    }

    public static boolean isLoggedIn()
    {
        if (currentUser != null)
        {
            return currentUser.getLoggedIn();
        }
        return false;
    }
}