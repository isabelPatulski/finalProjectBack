package kea.sem3.jwtdemo.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter
@ToString


public class ParentalRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String type;
    int ageLimit;

    public ParentalRating(int id, String type, int ageLimit) {
        this.id = id;
        this.type = type;
        this.ageLimit = ageLimit;
    }

    public ParentalRating() {

    }
}
