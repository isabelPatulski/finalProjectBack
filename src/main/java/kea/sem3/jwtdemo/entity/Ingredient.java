package kea.sem3.jwtdemo.entity;

import kea.sem3.jwtdemo.dto.IngredientRequest;
import kea.sem3.jwtdemo.dto.RecipeRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Ingredient {

    @Id
    String name;

    @Column
    int price;

    //@OneToMany(mappedBy = "ingredient", cascade = CascadeType.ALL, orphanRemoval = true)
    //private Set<RecipeLine> recipeLines = new HashSet<>();


    public Ingredient(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Ingredient(IngredientRequest body){
        this.name = body.getName();
        this.price = body.getPrice();
    }


}
