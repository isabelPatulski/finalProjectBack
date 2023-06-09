package kea.sem3.jwtdemo.entity;

import kea.sem3.jwtdemo.dto.RecipeLineRequest;
import kea.sem3.jwtdemo.dto.RecipeRequest;
import kea.sem3.jwtdemo.entity.Ingredient;
import kea.sem3.jwtdemo.entity.Recipe;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class RecipeLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    String ingredientName;

    String recipeName;

    private double amount;

    public RecipeLine(String ingredientName, double amount, String recipeName) {
        this.ingredientName = ingredientName;
        this.amount = amount;
        this.recipeName = recipeName;
    }

    public RecipeLine(RecipeLineRequest body){
        this.amount = body.getAmount();
        this.recipeName = body.getRecipeName();
        this.ingredientName = body.getIngredientName();
    }


}