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

    @OneToMany(mappedBy = "showingMovie")
    private Set<Movie> movies = new HashSet<>();

    public void addMovies (Movie movie){
        movies.add(movie);
    }

    public Showing() {
    }

    @ManyToOne
    CinemaHall showingHall;

    @OneToMany(mappedBy = "showingReserved")
    private Set<Reservation> reservations = new HashSet<>();

    public Showing(int id, LocalDate date, LocalDateTime time, int price, String seatType, CinemaHall showingHall) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.price = price;
        this.seatType = seatType;
        showingHall.addShowings(this);

    }
}
