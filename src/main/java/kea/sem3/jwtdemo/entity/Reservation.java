package kea.sem3.jwtdemo.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @CreationTimestamp
    LocalDate reservationCreated;

    LocalDate dateReserved;

    //Mange reservationer til én film
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name= "movie_id",referencedColumnName = "id")
    private Movie movieReserved;


    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name= "costumer_id",referencedColumnName = "id")
    private Costumer reservedByCustomer;


    public Reservation() {

    }

    public Reservation(LocalDate reservationCreated, LocalDate dateReserved, Movie movieReserved, Costumer costumerAdded) {
        this.reservationCreated = reservationCreated;
        this.dateReserved = dateReserved;
        movieReserved.addReservation(this);
        costumerAdded.addCustomer(this);

    }

    public Reservation(LocalDate dateReserved, Movie movieReserved, Costumer reservedByCustomer) {
        this.dateReserved = dateReserved;
        this.movieReserved = movieReserved;
        this.reservedByCustomer = reservedByCustomer;
    }

    /*public void makeReservation(Costumer costumer) {
        this.costumer = costumer;
    }


    public Reservation(int id, int costumerId, LocalDateTime date) {
        this.id = id;
        this.movieId = movieId;
        this.costumerId = costumerId;
        this.date = date;
    }*/
}
