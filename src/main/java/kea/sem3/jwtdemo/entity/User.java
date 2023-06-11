package kea.sem3.jwtdemo.entity;

import kea.sem3.jwtdemo.dto.UserRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString

public class User {
    @Id
    private String email;
    @Column(length = 100)
    private String password;
    boolean loggedIn;


    public User(String password, String email, boolean loggedIn) {
        this.email = email;
        this.password=password;
        this.loggedIn =loggedIn;
    }
    public boolean getLoggedIn () { return this.loggedIn;
    }

    public User(UserRequest body) {
        this.email = body.getEmail();
        this.password = body.getPassword();
    }

}