package kea.sem3.jwtdemo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import kea.sem3.jwtdemo.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {
    int id;
    String email;

    public UserResponse(User user) {
        this.email = user.getEmail();

    }

    public static List<UserResponse> getUsersFromEntities(List<User> users){
        return users.stream().map(user-> new UserResponse(user)).collect(Collectors.toList());
    }
}

