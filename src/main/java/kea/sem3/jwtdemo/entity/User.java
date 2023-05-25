package kea.sem3.jwtdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kea.sem3.jwtdemo.dto.UserRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString

public class User {
    @Id
    private String email;
    @Column(length = 100)
    private String username;
    private String password;
    private boolean loggedIn;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Reservation> reservations = new HashSet <>();


    public User(String password, String username, String email, boolean loggedIn) {
        this.username = username;
        this.email = email;
        this.password=password;
        this.loggedIn = false;
    }

    public User(UserRequest body) {
        this.username = body.getUsername();
        this.email = body.getEmail();
        this.password = body.getPassword();
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }


}