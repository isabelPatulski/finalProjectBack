package kea.sem3.jwtdemo.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int numbOfSeats;


    /*der kan være mange reservationer til en fremvisning
    /*name er navngivning af den kollen der skal oprettes
    referencedColumnName er fra hvilken kolonne inforationen skal hentes fra
    informationen hentes fra showing-table og specifikt fra kolonen der hedder id,
    som ligger i showing table */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Showing showing;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    public Reservation(int numbOfSeats, Showing showing, User user) {
        this.numbOfSeats = numbOfSeats;
        this.showing=showing;
        this.user = user;
    }

    public Reservation() {
    }


}
