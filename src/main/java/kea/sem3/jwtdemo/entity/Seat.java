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

public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int seatRow;
    int seatNumber;

    public Seat(int seatRow, int SeatNumber) {

        this.seatRow = seatRow;
        this.seatNumber = seatNumber;
    }

    public Seat() {
    }

    @OneToMany(mappedBy = "cinemaHallSeat")
    private Set<CinemaHall> cinemaHallSeats = new HashSet<>();

}
