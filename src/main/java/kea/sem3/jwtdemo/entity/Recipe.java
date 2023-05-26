package kea.sem3.jwtdemo.entity;


import kea.sem3.jwtdemo.dto.RecipeRequest;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(length = 60)
    String name;

    @Enumerated(EnumType.ORDINAL)
    Status mealType;

    @Column(length = 500)
    String description;


    @OneToMany(mappedBy = "recipe", fetch = FetchType.EAGER)
    private Set<Ingredient> ingredients = new HashSet<>();
    public void addIngredient(Ingredient sh){
        ingredients.add(sh);
        sh.setRecipe(this);
    }


    public Recipe(String name, String description, Status mealType) {
        this.name = name;
        this.mealType = mealType;
        this.description = description;
    }

    public Recipe(RecipeRequest body){
        this.name = body.getName();
        this.description = body.getDescription();
        this.mealType = body.getMealType();
    }
    public enum Status {
        Breakfast, Lunch, Dinner, Dessert;
    }


}