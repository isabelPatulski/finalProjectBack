package kea.sem3.jwtdemo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import kea.sem3.jwtdemo.entity.Ingredient;
import kea.sem3.jwtdemo.entity.RecipeLine;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IngredientRequest {
    private Ingredient.MeasurementType measurementType;
    private int price;
    private String name;


}
