package kea.sem3.jwtdemo.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
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
    int movieId;
    int dateID;
    int costumerId;
    //Skal vidst lige laves til date/time
    int date;

    public Reservation(int id, int movieId, int dateID, int costumerId, int date) {
        this.id = id;
        this.movieId = movieId;
        this.dateID = dateID;
        this.costumerId = costumerId;
        this.date = date;
    }

    public Reservation() {

    }

    @ManyToMany(mappedBy = "seatsReserved")
    private Set<Seat> seatsReserved = new HashSet<>();
}
