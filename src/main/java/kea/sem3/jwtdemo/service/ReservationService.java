package kea.sem3.jwtdemo.service;

import kea.sem3.jwtdemo.entity.Costumer;
import kea.sem3.jwtdemo.entity.Reservation;
import kea.sem3.jwtdemo.repositories.CostumerRepository;
import kea.sem3.jwtdemo.repositories.MovieRepository;
import kea.sem3.jwtdemo.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    ReservationRepository reservationRepository;
    MovieRepository movieRepository;
    CostumerRepository costumerRepository;


    public ReservationService(ReservationRepository reservationRepository, MovieRepository movieRepository, CostumerRepository costumerRepository) {
        this.reservationRepository = reservationRepository;
        this.movieRepository = movieRepository;
        this.costumerRepository = costumerRepository;
    }


    public
    //Get certain costumer
    //Get certain movie

    //Get certain reservation


    //GetAlleReservation for a costumer
    //GetALLReservations for a certaain movie
    //Get a certain reservation
    //Delete a certaain reservation

}
