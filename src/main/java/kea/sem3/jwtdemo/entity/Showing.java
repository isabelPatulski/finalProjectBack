package kea.sem3.jwtdemo.entity;

import kea.sem3.jwtdemo.dto.MovieRequest;
import kea.sem3.jwtdemo.dto.ShowingRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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

    @CreationTimestamp
    LocalDate date;

    @UpdateTimestamp
    LocalTime time;

    @Column
    int price;

    //Connecter hall & showing

    /*Cascade gør at når denne showing slettes, så slettes hall også
    Dette er ikke optimtalt, da en hall sagtens kan eksistere selvom en showing ikke eksisterer
    Den bruges dog i dette projekt for at være sikker på at foreign-keys slettes ifm. deleteAll-metoden i config */

    @ManyToOne (cascade= CascadeType.ALL)
    private CinemaHall cinemaHall;

    //Connecter movie & showing
    @ManyToOne(cascade= CascadeType.ALL, fetch = FetchType.EAGER)
    private Movie movie;

    @OneToMany(mappedBy = "showing")
    private Set<Reservation> reservations= new HashSet<>();
    public void addReservation(Reservation res){
        reservations.add(res);
        res.setShowing(this);
    }

    public Showing(LocalDate date, LocalTime time, Movie movie, CinemaHall cinemaHall) {
    this.date=date;
    this.time=time;
    this.movie= movie;
    this.cinemaHall=cinemaHall;
    }

    public Showing(LocalDate date, LocalTime time, int price) {
        this.date = date;
        this.time = time;
        this.price = price;
    }

    public Showing() {
    }

}
