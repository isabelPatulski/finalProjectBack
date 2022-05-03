package kea.sem3.jwtdemo.repositories;

import com.sun.xml.bind.v2.model.core.ID;
import kea.sem3.jwtdemo.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}