package kea.sem3.jwtdemo.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString

public class Popularity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int numberOfResevation;

    boolean popular;

    @ManyToOne
    Movie likesMovie;

}
