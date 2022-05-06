package kea.sem3.jwtdemo.entity;


import kea.sem3.jwtdemo.dto.MovieRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.convert.DurationFormat;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
@ToString
public class Movie{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;


    //TODO: spørge om hjælp til dette hos lars.
    // Duration duration =Duration.between()

    /*TODO kan først laves, når genre er blevet lavet
    @OneToMany
    Genre movieGenre;*/

    public Movie() {}


    public Movie(String title, String category) {
        this.title = title;
        this.genre = category;
    }

    public Movie(MovieRequest body){
        this.title = body.getTitle();
        this.genre = body.getGenre();
    }
    @Column(length = 60)
    String title;

    @Column(length = 60)
    String genre;

    @CreationTimestamp
    LocalDateTime created;

    @UpdateTimestamp
    LocalDateTime edited;


    /*
    @OneToMany (mappedBy = "reservedMovie", fetch = FetchType.EAGER)
    private Set<Reservation> reservations = new HashSet<>();



    public void addReservation(Reservation res){
        reservations.add(res);
    }

     */

}
