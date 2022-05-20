package kea.sem3.jwtdemo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import kea.sem3.jwtdemo.entity.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShowingResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    LocalDate date;

    @JsonFormat(pattern="HH:mm:ss")
    LocalTime time;

    int price;

    int cinemaHallId;

    String movie;


    public ShowingResponse(Showing showing){
        this.date=showing.getDate();
        this.time= showing.getTime();
        this.price=showing.getPrice();
        this.cinemaHallId = showing.getCinemaHall().getId();
        this.movie= showing.getMovie().getTitle();
    }


    public static List<ShowingResponse> getShowingsFromEntities(List<Showing> showings){
        return showings.stream().map(showing-> new ShowingResponse(showing)).collect(Collectors.toList());
    }

    /*public static List<ShowingResponse> getShowingsFromEntities(List<Showing> showings){
        return showings.stream().map(showing-> new ShowingResponse(showing)).collect(Collectors.toList());
    }*/
}
