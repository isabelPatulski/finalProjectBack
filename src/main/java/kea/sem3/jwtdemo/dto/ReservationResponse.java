package kea.sem3.jwtdemo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import kea.sem3.jwtdemo.entity.Reservation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservationResponse {
    private int id;
    private LocalDate reservationCreated;
    private LocalDate dateReserved;


    public ReservationResponse(Reservation reservation) {
        this.id = reservation.getId();
        this.reservationCreated=reservation.getReservationCreated();
        this.dateReserved=reservation.getDateReserved();


    }

    public static List<ReservationResponse> getReservationsFromEntities(List<Reservation> reservations){
        return reservations.stream().map(reservation -> new ReservationResponse(reservation)).collect(Collectors.toList());
    }



}
