package kea.sem3.jwtdemo.entity;


import kea.sem3.jwtdemo.dto.PopularityRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter @Setter
@ToString

public class Popularity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int numberOfResevation;

    boolean isPopular;

    @ManyToOne
    Movie likesMovie;

    public Popularity() {
    }

    public Popularity(int id, int numberOfResevation, boolean isPopular) {
        this.id = id;
        this.numberOfResevation = numberOfResevation;
        this.isPopular = isPopular;

    }

    public Popularity(PopularityRequest body){
        this(body.getId(), body.getNumberOfResevation(), body.isPopular());
    }




}
