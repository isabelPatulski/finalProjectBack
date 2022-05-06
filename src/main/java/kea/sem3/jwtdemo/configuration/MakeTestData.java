package kea.sem3.jwtdemo.configuration;

import kea.sem3.jwtdemo.entity.*;
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
    UserRepository userRepository;

    public MakeTestData(MovieRepository movieRepository, UserRepository userRepository) {
        this.movieRepository = movieRepository;
        this.userRepository = userRepository;
    }

    public  void makePlainTestData(){
        BaseUser user = new BaseUser("user", "user@a.dk", "test12");
        BaseUser admin = new BaseUser("admin", "admin@a.dk", "test12");
        BaseUser both = new BaseUser("user_admin", "both@a.dk", "test12");

        userRepository.save(user);
        userRepository.save(admin);
        userRepository.save(both);

    /*public Movie(String title, String genre, int price, String description, String rating, int ageLimit)*/


        movieRepository.save(new Movie("The Green Man", "Horror", 80, "This is a description", "PG-13", 13));
        movieRepository.save(new Movie("Some Women Dancing", "Comedy", 80, "This is a description", "PG", 7));
        movieRepository.save(new Movie("In Captivity", "Thriller", 80, "This is a description", "R", 18));
        movieRepository.save(new Movie("The Love Birds", "Romance", 80, "This is a description", "PG-13", 13));
        movieRepository.save(new Movie("Angry People Watching", "Action", 80, "This is a description", "PG-13", 13));
        movieRepository.save(new Movie("Space Walking", "Science Fiction", 80, "This is a description", "NC-17", 21));


        System.out.println("########################################################################################");
        System.out.println("########################################################################################");
        System.out.println("#################################### WARNING ! #########################################");
        System.out.println("## This part breaks a fundamental security rule -> NEVER ship code with default users ##");
        System.out.println("########################################################################################");
        System.out.println("########################  REMOVE BEFORE DEPLOYMENT  ####################################");
        System.out.println("########################################################################################");
        System.out.println("########################################################################################");
        System.out.println("Created TEST Users");

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        movieRepository.deleteAll();
        makePlainTestData();


    }
}
