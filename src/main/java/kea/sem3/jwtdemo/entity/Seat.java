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

    @OneToMany(mappedBy = "seatInHall")
    private Set<CinemaHall> seatsInHall = new HashSet<>();

    public void addHalls (CinemaHall seatInHall){
        seatsInHall.add(seatInHall);
    }


    public Seat(int seatRow, int seatNumber) {
        this.seatRow = seatRow;
        this.seatNumber = seatNumber;
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
