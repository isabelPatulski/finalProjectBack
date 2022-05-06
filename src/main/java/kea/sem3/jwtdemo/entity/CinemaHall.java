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
    int seat;
    int seatRow;

    public CinemaHall(int id, int hallNumber, int seat, int row) {
        this.id = id;
        this.hallNumber = hallNumber;
        this.seat = seat;
        this.seatRow = row;
    }

    public CinemaHall() {
    }

    @OneToMany(mappedBy = "showingHall")
    private Set<Showing> showings = new HashSet<>();

}
