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

    @ManyToOne(fetch = FetchType.LAZY)
    private Recipe recipe;

    @ManyToOne(fetch = FetchType.EAGER)
    private Ingredient ingredient;

    @Enumerated(EnumType.STRING)
    private MeasurementType measureType;

    private String narration;

    public RecipeLine(Ingredient ingredient, MeasurementType measureType, String narration) {
        //this.ingredient = ingredient;
        this.measureType = measureType;
        this.narration = narration;
    }

    public RecipeLine(RecipeLineRequest body){
        this.measureType = body.getMeasurementType();
        this.narration = body.getNarration();
    }

    public enum MeasurementType {
        LITER,
        CUP,
        GRAM,
    }
}