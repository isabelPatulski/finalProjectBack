package kea.sem3.jwtdemo.dto;

import kea.sem3.jwtdemo.entity.RecipeLine;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecipeLineRequest {

    private RecipeLine.MeasurementType measurementType;

    private double amount;

    public int recipeId;

    public int ingredientId;


}
