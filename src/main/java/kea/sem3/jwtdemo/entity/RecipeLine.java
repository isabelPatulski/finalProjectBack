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

    @Enumerated(EnumType.STRING)
    private MeasurementType measureType;

    private double amount;

    public RecipeLine(String ingredientName, MeasurementType measureType, double amount, String recipeName) {
        this.ingredientName = ingredientName;
        this.measureType = measureType;
        this.amount = amount;
        this.recipeName = recipeName;
    }

    public RecipeLine(RecipeLineRequest body){
        this.measureType = body.getMeasurementType();
        this.amount = body.getAmount();
        this.recipeName = body.getRecipeName();
        this.ingredientName = body.getIngredientName();
    }

    public enum MeasurementType {
        LITER,
        CUP,
        GRAM,
        PCS,
        TBS,
    }
}