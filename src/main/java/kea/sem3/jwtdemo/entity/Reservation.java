package kea.sem3.jwtdemo.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
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


    @ManyToMany
    @JoinTable(
            //making a new column called showing_seats
            name="showing_seats",
            //and it's going to join, using the column called reservation_id
            joinColumns = @JoinColumn(name="reservation_id"),
            inverseJoinColumns =@JoinColumn(name = "seat_id")
    )
    private Set<Seat> seatsReserved = new HashSet<>();

    public void addSeats(Seat seat){
        seatsReserved.add(seat);
    }


    @OneToMany (mappedBy = "reservedMovie", fetch = FetchType.EAGER)
    private Set<Reservation> reservations = new HashSet<>();

    public void addReservation(Reservation res){
        reservations.add(res);
    }

    //mange reservationer til én film
    @ManyToOne
    Showing showingReserved;

}
