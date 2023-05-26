package kea.sem3.jwtdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationRequest {

    //private  int costumerId;
    //private int customerId;

    private int showingId;

    /*En liste af seatId, som er reseveret
    Listen skal gerne indeholde en liste over de seatId som er blevet reseveret*/
    private int numbOfSeats;

}
