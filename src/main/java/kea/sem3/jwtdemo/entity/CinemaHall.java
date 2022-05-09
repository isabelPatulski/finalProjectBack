package kea.sem3.jwtdemo.entity;


import lombok.AccessLevel;
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
    //@Setter(AccessLevel.NONE)
    //@Getter(AccessLevel.NONE)

    private Set<Showing> showings = new HashSet<>();


    public void addShowings (Showing show){
        showings.add(show);
    }

    @ManyToOne
    Seat cinemaHallSeat;

    public CinemaHall(int id, int hallNumber, int level, Seat seat) {
        this.id = id;
        this.hallNumber = hallNumber;
        this.level = level;
        seat.addCinemaHall(this);
    }
}
