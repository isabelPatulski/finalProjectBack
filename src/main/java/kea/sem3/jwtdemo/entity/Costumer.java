package kea.sem3.jwtdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString

public class Costumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String surname;
    String email;
    int birthday;

    @JsonIgnore
    @OneToMany(mappedBy = "costumer")
    private Set<Reservation> reservations = new HashSet <>();


    public Costumer(int id, String name, String surname, String email, int birthday) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthday = birthday;
    }

    public Costumer() {

    }

    public Set<Reservation> getReservations() {
        return reservations;
    }
}