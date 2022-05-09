package kea.sem3.jwtdemo.dto;

import kea.sem3.jwtdemo.entity.Movie;
import kea.sem3.jwtdemo.entity.Seat;

import java.util.List;
import java.util.stream.Collectors;

public class SeatResponse {
    int seatRow;
    int seatNumber;

    public SeatResponse(int seatRow, int seatNumber) {
        this.seatRow = seatRow;
        this.seatNumber = seatNumber;
    }

    public SeatResponse(Seat seat){
        this.seatRow= seat.getSeatRow();
        this.seatNumber=seat.getSeatNumber();
    }

    public static List<SeatResponse> getMoviesFromEntities(List<Seat> seats){
        return seats.stream().map(seat-> new SeatResponse(seat)).collect(Collectors.toList());
    }

}
