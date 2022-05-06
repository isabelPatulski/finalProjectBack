package kea.sem3.jwtdemo.configuration;

import kea.sem3.jwtdemo.entity.*;
import kea.sem3.jwtdemo.repositories.CostumerRepository;
import kea.sem3.jwtdemo.repositories.MovieRepository;
import kea.sem3.jwtdemo.repositories.ReservationRepository;
import kea.sem3.jwtdemo.security.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.time.Month;

@Controller
@Profile("!test")
public class MakeTestData implements ApplicationRunner {



    MovieRepository movieRepository;
    CostumerRepository costumerRepository;
    ReservationRepository reservationRepository;


    public MakeTestData(MovieRepository movieRepository, CostumerRepository costumerRepository, ReservationRepository reservationRepository) {
        this.movieRepository = movieRepository;
        this.costumerRepository = costumerRepository;
        this.reservationRepository = reservationRepository;
    }

    public  void makeTestData(){
        Movie movie1 = new Movie("inception", "thriller");
        Costumer c1= new Costumer("hans123","hans11@gmail.com",20);




        //Create Reservation
        Reservation res1= new Reservation(LocalDate.of(2022,03,01), movie1, c1);
        reservationRepository.save(res1);

        Reservation res= reservationRepository.
                findReservationByMovieReserved_idAnddateReserved(movie1.getId(),LocalDate.of(2022,3,1));





    }

    @Override
    public void run(ApplicationArguments args) throws Exception {



    }
}
