package kea.sem3.jwtdemo.service;

import kea.sem3.jwtdemo.dto.*;
import kea.sem3.jwtdemo.entity.Reservation;
import kea.sem3.jwtdemo.entity.Seat;
import kea.sem3.jwtdemo.entity.Showing;
import kea.sem3.jwtdemo.error.Client4xxException;
import kea.sem3.jwtdemo.repositories.ReservationRepository;
import kea.sem3.jwtdemo.repositories.ShowingRepository;

import java.util.List;

public class ShowingService {

    ShowingRepository showingRepository;
    ReservationRepository reservationRepository;


    public ShowingResponse getShowing(int id){
        return new ShowingResponse(showingRepository.findById(id).orElseThrow(()-> new Client4xxException("No showing reservation id:" + id)));

    }

    public List<Showing> getAllShowings(){
        return showingRepository.findAll();
    }

}
