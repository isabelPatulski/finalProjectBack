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

    //mange reservationer til én filmvisning
    @ManyToOne
    Showing showingReserved;

    public Reservation() {
    }

    public Reservation(Showing showingReserved, Set<Seat> seatsReserved) {

        showingReserved.addResevertaion(this);
        this.seatsReserved= seatsReserved;
    }
}
