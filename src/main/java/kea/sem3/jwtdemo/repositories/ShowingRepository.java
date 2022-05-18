package kea.sem3.jwtdemo.repositories;

import kea.sem3.jwtdemo.entity.Showing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowingRepository extends JpaRepository<Showing, Integer> {

}
