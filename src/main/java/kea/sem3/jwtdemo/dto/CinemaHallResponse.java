package kea.sem3.jwtdemo.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import kea.sem3.jwtdemo.entity.CinemaHall;
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

    private int numbSeats;

    public CinemaHallResponse(CinemaHall ch){
        this.numbSeats= ch.getNumbSeats();
    }

    public static List<CinemaHallResponse> getCinemaHallFromEntities(List<CinemaHall> cinemaHalls){
        return cinemaHalls.stream().map(cinemaHall -> new CinemaHallResponse(cinemaHall)).collect(Collectors.toList());

    }
}
