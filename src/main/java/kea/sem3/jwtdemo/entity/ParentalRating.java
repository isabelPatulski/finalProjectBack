package kea.sem3.jwtdemo.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@ToString
@Setter @Getter
public class ParentalRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String ratingType;
    int ageLimit;

    public ParentalRating(String ratingType, int ageLimit) {
        this.ratingType = ratingType;
        this.ageLimit = ageLimit;
    }

    public ParentalRating() {

    }

}
