package kea.sem3.finalProject.dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import kea.sem3.finalProject.entity.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IngredientResponse {

    double price;
    String name;
    Ingredient.MeasurementType measurementType;

    public IngredientResponse(Ingredient ingredient){
        this.price=ingredient.getPrice();
        this.name = ingredient.getName();
        this.measurementType = ingredient.getMeasureType();
    }


    public static List<IngredientResponse> getIngredientsFromEntities(List<Ingredient> ingredients){
        return ingredients.stream().map(ingredient-> new IngredientResponse(ingredient)).collect(Collectors.toList());
    }


}
