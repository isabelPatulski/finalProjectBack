package kea.sem3.jwtdemo.service;

import kea.sem3.jwtdemo.dto.ReservationResponse;
import kea.sem3.jwtdemo.entity.Costumer;
import kea.sem3.jwtdemo.entity.Reservation;
import kea.sem3.jwtdemo.error.Client4xxException;
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


    public ReservationResponse getReservation(int id){
        return new ReservationResponse(reservationRepository.findById(id).orElseThrow(()-> new Client4xxException("No car reservation id:" + id)));

    }

    public List<Reservation> getAllReservation(){
        return reservationRepository.findAll();
    }

}
