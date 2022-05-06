package kea.sem3.jwtdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString

public class Costumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String username;
    String email;
    int birthday;


    @OneToMany (mappedBy = "reservedByCustomer", fetch = FetchType.EAGER)
    /*En costumer kan have flere reservationer, derofr skal der laves en liste/set
    af de reservationer som costumer har*/
    private Set<Reservation> reservations = new HashSet<>();


    public Costumer(String username, String email, int birthday) {
        this.username = username;
        this.email = email;
        this.birthday = birthday;
    }



    public Costumer() {

    }


    /*public Set<Reservation> getReservations() {
        return reservations;
    }*/

    public void addCustomer(Reservation res){
        reservations.add(res);
    }
}