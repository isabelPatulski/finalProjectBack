package kea.sem3.jwtdemo.configuration;

import kea.sem3.jwtdemo.entity.*;
import kea.sem3.jwtdemo.repositories.MovieRepository;
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


    UserRepository userRepository;
    MovieRepository movieRepository;

    public MakeTestData(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public  void makePlainTestData(){
        /*
        BaseUser user = new BaseUser("user", "user@a.dk", "test12");
        BaseUser admin = new BaseUser("admin", "admin@a.dk", "test12");
        BaseUser both = new BaseUser("user_admin", "both@a.dk", "test12");

        userRepository.save(user);
        userRepository.save(admin);
        userRepository.save(both);


         */
        Movie movie1 = movieRepository.save(new Movie("The Green Man", "Horror"));
        Movie movie2 = movieRepository.save(new Movie("Some Women Dancing", "Comedy"));
        Movie movie3 = movieRepository.save(new Movie("In Captivity", "Thriller"));
        Movie movie4 = movieRepository.save(new Movie("The Love Birds", "Romance"));
        Movie movie5 = movieRepository.save(new Movie("Angry People Watching", "Action"));
        Movie movie6 = movieRepository.save(new Movie("Space Walking", "Science Fiction"));


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
