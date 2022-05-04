package kea.sem3.jwtdemo.entity;


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
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;


    @OneToMany (mappedBy = "reservedMovie", fetch = FetchType.EAGER)
    private Set<Reservation> reservations = new HashSet<>();

    public void addReservation(Reservation res){
        reservations.add(res);
    }

    //mange reservationer til én film
    @ManyToOne
    Movie reservedMovie;


}
