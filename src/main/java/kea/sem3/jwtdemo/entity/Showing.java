package kea.sem3.jwtdemo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

    LocalDateTime time;

    int price;

    String seatType;

    @ManyToOne
    CinemaHall showingHall;


    @OneToMany(mappedBy = "showingMovie")//TODO skal dette tilføjes som en SET<Movie> movies i Showingrequesten????
    private Set<Movie> movies = new HashSet<>();

    public void addMovies (Movie movie){
        movies.add(movie);
    }

    public Showing() {
    }


    @OneToMany(mappedBy = "showingReserved")
    private Set<Reservation> reservations = new HashSet<>();

    public void addResevertaion (Reservation res){
        reservations.add(res);
    }

    public Showing(int id, LocalDate date, LocalDateTime time, int price, String seatType, CinemaHall showingHall, Reservation showingReserved) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.price = price;
        this.seatType = seatType;
        showingHall.addShowings(this);
    }

    //TODO skal denne klasse have som linjerne nedenunder???
    /*public Car(CarRequest body) {
        this.brand = body.getBrand();
        this.model = body.getModel();
        this.pricePrDay = body.getPricePrDay();
        this.bestDiscount= body.getPricePrDay();
    }*/
}
