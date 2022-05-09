package kea.sem3.jwtdemo.entity;


import kea.sem3.jwtdemo.dto.SeatRequest;
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

    public Seat(int id, int seatRow, int seatNumber) {
        this.id = id;
        this.seatRow = seatRow;
        this.seatNumber = seatNumber;
    }



    public Seat() {
    }

    @OneToMany(mappedBy = "cinemaHallSeat")
    private Set<CinemaHall> cinemaHallSeats = new HashSet<>();

    public Seat(SeatRequest seatRequest) {
        this.id = seatRequest.getId();
        this.seatRow = seatRequest.getSeatRow();
        this.seatNumber = seatRequest.getSeatNumber();
    }
}
