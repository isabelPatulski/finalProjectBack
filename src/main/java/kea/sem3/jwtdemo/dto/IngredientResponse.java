package kea.sem3.jwtdemo.dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import kea.sem3.jwtdemo.entity.*;
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

    int price;
    String name;
    //String recipe;


    public IngredientResponse(Ingredient ingredient){
        this.price=ingredient.getPrice();
        this.name = ingredient.getName();
        //this.recipe= ingredient.getRecipe();
    }


    public static List<IngredientResponse> getIngredientsFromEntities(List<Ingredient> ingredients){
        return ingredients.stream().map(ingredient-> new IngredientResponse(ingredient)).collect(Collectors.toList());
    }

}
