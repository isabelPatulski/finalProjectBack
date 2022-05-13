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

    @CreationTimestamp
    LocalTime time;

    @Column
    int price;

    //Connecter hall & showing
    @ManyToOne (cascade= CascadeType.ALL)
    // @JoinColumn(name = "cinema_hall_id")
    @JoinColumn(name= "cinema_hall_id", referencedColumnName= "id")
    private CinemaHall cinemaHall;


    //Connecter movie & showing
    @ManyToOne (cascade= CascadeType.ALL)
    @JoinColumn(name= "movie_id", referencedColumnName= "id")
    private Movie movie;





    public Showing() {
    }

    public Showing(LocalDate date, LocalTime time, int price) {
        this.date = date;
        this.time = time;
        this.price = price;
    }

    public Showing(ShowingRequest body){
        this.date = body.getDate();
        this.time = body.getTime();
        this.price = body.getPrice();
    }

}
