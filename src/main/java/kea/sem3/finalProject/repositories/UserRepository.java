package kea.sem3.finalProject.repositories;


import kea.sem3.finalProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Boolean existsByEmail(String email);
    User findByEmail (String email);

    @Query("select (count(m) > 0) from User m where m.email = :email")
    boolean emailExist(String email);

}
