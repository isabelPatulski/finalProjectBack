package kea.sem3.jwtdemo.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    //der kan være mange reservationer til en fremvisning
    @ManyToOne
    @JoinColumn(name = "showing_id")
    private Showing showing;

    public Reservation() {
    }




}
