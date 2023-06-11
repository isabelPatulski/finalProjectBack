package kea.sem3.jwtdemo.dto;

import kea.sem3.jwtdemo.entity.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IngredientRequest {
    private Ingredient.MeasurementType measurementType;
    private int price;
    private String name;


}
