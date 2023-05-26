package kea.sem3.jwtdemo.entity;


import kea.sem3.jwtdemo.dto.CinemaHallRequest;
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
    int numbSeats;

    //Connecter mellem showings & hall
    @OneToMany(mappedBy = "cinemaHall")
    private Set<Showing> showings = new HashSet<>();

    public void addShowing(Showing show) {
        showings.add(show);
        show.setCinemaHall(this);
    }

    public CinemaHall(CinemaHallRequest body) {
        this.numbSeats = body.getNumbSeats();
    }

    public CinemaHall() {
    }

    public CinemaHall(int antalSeat) {
        this.numbSeats=antalSeat;
    }


}
