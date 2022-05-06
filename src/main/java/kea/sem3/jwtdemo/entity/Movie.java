package kea.sem3.jwtdemo.entity;


import kea.sem3.jwtdemo.dto.MovieRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.convert.DurationFormat;

import javax.persistence.*;
import java.time.Duration;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
@ToString
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String title;
    String genre;



    //TODO: spørge om hjælp til dette hos lars.
    // Duration duration =Duration.between()

    /*TODO kan først laves, når genre er blevet lavet
    @OneToMany
    Genre movieGenre;*/

    public Movie() {}


    public Movie(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    public Movie(MovieRequest body){
        this(body.getTitle(), body.getGenre());
    }

    @OneToMany (mappedBy = "movieReserved", fetch = FetchType.EAGER)
    private Set<Reservation> reservations = new HashSet<>();

    public void addReservation(Reservation res){
        reservations.add(res);
    }

}
