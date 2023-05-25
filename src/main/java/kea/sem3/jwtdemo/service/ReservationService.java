package kea.sem3.jwtdemo.service;


import kea.sem3.jwtdemo.dto.ReservationRequest;
import kea.sem3.jwtdemo.dto.ReservationResponse;

import kea.sem3.jwtdemo.entity.*;
import kea.sem3.jwtdemo.error.Client4xxException;

import kea.sem3.jwtdemo.repositories.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    ReservationRepository reservationRepository;
    MovieRepository movieRepository;
    ShowingRepository showingRepository;
    UserRepository customerRepository;

    public ReservationService(ReservationRepository reservationRepository, MovieRepository movieRepository, ShowingRepository showingRepository, UserRepository customerRepository) {
        this.reservationRepository = reservationRepository;
        this.movieRepository = movieRepository;
        this.showingRepository = showingRepository;
        this.customerRepository = customerRepository;
    }

    public ReservationResponse getReservation(int id){
        return new ReservationResponse(reservationRepository.findById(id).orElseThrow(()-> new Client4xxException("No car reservation id:" + id)));
    }

    public List<ReservationResponse> getAllReservation(){
        return ReservationResponse.getShowingsFromEntities(reservationRepository.findAll());
    }

    public ReservationResponse create(ReservationRequest reservationRequest) {
        Showing showing = showingRepository.findById(reservationRequest.getShowingId()).orElseThrow();
        User customer = customerRepository.findById(reservationRequest.getCustomerId()).orElseThrow();
        //  public Reservation(int numbOfSeats, Showing showing, Customer customer)
        Reservation reservation = new Reservation(reservationRequest.getNumbOfSeats(),showing, customer);
        ReservationResponse reservationResponse = new ReservationResponse(reservation);

        return reservationResponse;
    }
}
