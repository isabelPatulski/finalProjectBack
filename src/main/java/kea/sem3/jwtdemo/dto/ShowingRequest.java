package kea.sem3.jwtdemo.dto;

import kea.sem3.jwtdemo.entity.CinemaHall;
import kea.sem3.jwtdemo.entity.Movie;
import kea.sem3.jwtdemo.entity.Reservation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

public class ShowingRequest {
    private LocalDate date;

    private LocalDateTime time;

    private int price;

    private int cinemaId;

    private int movieId;
}
