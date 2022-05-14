package kea.sem3.jwtdemo.entity;


import kea.sem3.jwtdemo.dto.MovieRequest;
import kea.sem3.jwtdemo.dto.ReservationRequest;
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

    //der kan være mange reservationer til en fremvisning
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "showing_id", referencedColumnName = "id")
    private Showing showing;

    @ManyToMany
    @JoinTable(
            name = "showSeat",
            joinColumns= @JoinColumn(name="reservation_id"),
          inverseJoinColumns = @JoinColumn(name="seat_id")

    )
    private Set<Seat> seatsReserved= new HashSet<>();


    public Reservation() {
    }




}
