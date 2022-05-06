package kea.sem3.jwtdemo.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import kea.sem3.jwtdemo.entity.CinemaHall;
import kea.sem3.jwtdemo.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class CinemaHallResponse {

    private int hallNumber;
    private int level;


    public CinemaHallResponse(CinemaHall cinemaHall) {
        this.hallNumber = cinemaHall.getHallNumber();
        this.level = cinemaHall.getLevel();
    }

    public static List<CinemaHallResponse> getCinemaHallFromEntities(List<CinemaHall> cinemaHalls){
        return cinemaHalls.stream().map(cinemaHall -> new CinemaHallResponse(cinemaHall)).collect(Collectors.toList());

    }
}
