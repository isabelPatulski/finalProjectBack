package kea.sem3.jwtdemo.entity;


import kea.sem3.jwtdemo.dto.SeatRequest;
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

public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int seatRow;
    int seatNumber;


    @ManyToMany(mappedBy= "seats" )
    public Set<Reservation> reservations = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "cinema_hall_id")
    private CinemaHall cinemaHall;


    public Seat(int seatRow, int seatNumber, CinemaHall cinemaHall) {
        this.seatRow = seatRow;
        this.seatNumber = seatNumber;
        this.cinemaHall=cinemaHall;
    }



    public Seat() {
    }









    @ManyToMany(mappedBy = "seatsReserved")
    private Set<Reservation> seatsReserved = new HashSet<>();

    public void addReservation (Reservation res){
        seatsReserved.add(res);
    }

    public Seat(SeatRequest seatRequest) {
        this.id = seatRequest.getId();
        this.seatRow = seatRequest.getSeatRow();
        this.seatNumber = seatRequest.getSeatNumber();
    }
}
