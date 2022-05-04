package kea.sem3.jwtdemo.service;

import kea.sem3.jwtdemo.entity.Reservation;
import kea.sem3.jwtdemo.repositories.MovieRepository;
import kea.sem3.jwtdemo.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    ReservationRepository reservationRepository;
    MovieRepository movieRepository;


    public ReservationService(ReservationRepository reservationRepository, MovieRepository movieRepository) {
        this.reservationRepository = reservationRepository;
        this.movieRepository = movieRepository;
    }

    public List<Reservation> getAllReservation(){
        return reservationRepository.findAll();
    }

}
