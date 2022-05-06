package kea.sem3.jwtdemo.api;

import kea.sem3.jwtdemo.entity.Costumer;
import kea.sem3.jwtdemo.entity.Reservation;
import kea.sem3.jwtdemo.repositories.CostumerRepository;
import kea.sem3.jwtdemo.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    CostumerRepository costumerRepository;

    @GetMapping
    List<Reservation> getReservations () {return reservationRepository.findAll();}

    @PostMapping
    Reservation createReservation (@RequestBody Reservation reservation) {return reservationRepository.save(reservation);}

    /*
    @PutMapping("/{reservationId}/costumer/{costumerId}")
    Reservation costumerReservations (
            @PathVariable int reservationId,
            @PathVariable int costumerId
    ) {
        Reservation reservation = reservationRepository.findById(reservationId).get();
        Costumer costumer = costumerRepository.findById(costumerId).get();
        reservation.makeReservation(costumer);
        return reservationRepository.save(reservation);
    }

     */
}