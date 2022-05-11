package kea.sem3.jwtdemo.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.*;
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


    @ManyToOne
    @JoinColumn(name = "showing_id")
    private Showing showing;



    @ManyToMany
    @JoinTable(name = "reservation_seats_reserved",
            joinColumns = @JoinColumn(name = "reservation_id", referencedColumnName = "seats_reserved_id"))
    private Set<Seat> seats = new HashSet<>();


    public Reservation() {
    }




    /*@ManyToMany
    @JoinTable(
            //making a new column called showing_seats
            name="showing_seats",
            //and it's going to join, using the column called reservation_id
            joinColumns = @JoinColumn(name="reservation_id"),
            inverseJoinColumns =@JoinColumn(name = "seat_id")
    )
    private Set<Seat> seatsReserved = new HashSet<>();*/



}
