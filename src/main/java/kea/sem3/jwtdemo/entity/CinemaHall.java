package kea.sem3.jwtdemo.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
@ToString

public class CinemaHall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int hallNumber;

    //altså etage
    int level;


    @OneToMany(mappedBy = "showingHall")
    private Set<Showing> showings = new HashSet<>();

    @ManyToOne
    Seat cinemaHallSeat;

}
