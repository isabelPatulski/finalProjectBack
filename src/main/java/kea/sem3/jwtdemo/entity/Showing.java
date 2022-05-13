package kea.sem3.jwtdemo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Showing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    LocalDate date;

    LocalTime time;

    int price;


    //Connecter movie & showing
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    //Connecter hall & showing
    @ManyToOne
    @JoinColumn(name = "cinema_hall_id")
    private CinemaHall cinemaHall;


    //Connecter reservation & showing
    //En shwoing kan have flere reservationer
    @OneToMany(mappedBy = "showing")
    private Set<Reservation> reservations= new HashSet<>();

    public void addReservation(Reservation res){
        reservations.add(res);
        res.setShowing(this);
    }

    public Showing() {
    }

    public Showing(LocalDate date, LocalTime time, int price) {
        this.date = date;
        this.time = time;
        this.price = price;
    }


    /*public Car(CarRequest body) {
        this.brand = body.getBrand();
        this.model = body.getModel();
        this.pricePrDay = body.getPricePrDay();
        this.bestDiscount= body.getPricePrDay();
    }*/
}
