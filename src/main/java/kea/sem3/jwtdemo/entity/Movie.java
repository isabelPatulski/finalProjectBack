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


    public Movie(int id, String title, String category) {
        this.id = id;
        this.title = title;
        this.genre = category;
    }

    public Movie(MovieRequest body){
        this(body.getId(), body.getTitle(), body.getCategory());
    }

    @OneToMany (mappedBy = "reservedMovie", fetch = FetchType.EAGER)
    private Set<Reservation> reservations = new HashSet<>();

    public void addReservation(Reservation res){
        reservations.add(res);
    }

    @OneToMany(mappedBy = "likesMovie", fetch = FetchType.EAGER)
    private Set<Popularity> popularities = new HashSet<>();

    public void addPopularity(Popularity pop) {
        popularities.add(pop);
    }
}
