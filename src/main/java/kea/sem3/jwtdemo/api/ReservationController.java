package kea.sem3.jwtdemo.api;

import kea.sem3.jwtdemo.entity.Customer;
import kea.sem3.jwtdemo.entity.Reservation;
import kea.sem3.jwtdemo.repositories.CustomerRepository;
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
    CustomerRepository customerRepository;

    @GetMapping
    List<Reservation> getReservations () {return reservationRepository.findAll();}

    @PostMapping
    Reservation createReservation (@RequestBody Reservation reservation) {return reservationRepository.save(reservation);}

    @PutMapping("/{reservationId}/customer/{customerId}")
    Reservation customerReservations (
            @PathVariable int reservationId,
            @PathVariable int customerId
    ) {
        Reservation reservation = reservationRepository.findById(reservationId).get();
        Customer customer = customerRepository.findById(customerId).get();
        reservation.makeReservation(customer);
        return reservationRepository.save(reservation);
    }
}