package kea.sem3.jwtdemo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(length = 15)
    String name;

    @Column
    int price;

    /*Cascade gør at når denne showing slettes, så slettes hall også
    Dette er ikke optimtalt, da en hall sagtens kan eksistere selvom en showing ikke eksisterer
    Den bruges dog i dette projekt for at være sikker på at foreign-keys slettes ifm. deleteAll-metoden i config */

    //Connecter movie & showing
    @ManyToOne(cascade= CascadeType.ALL, fetch = FetchType.EAGER)
    private Recipe recipe;

    //HELP: Skal den have recipe her? det havde den gamle (altså en movie)
    public Ingredient(String name, int price) {
    this.name = name;
    this.price = price;
    }


}