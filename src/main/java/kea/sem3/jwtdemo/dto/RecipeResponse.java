package kea.sem3.jwtdemo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import kea.sem3.jwtdemo.entity.Recipe;
import kea.sem3.jwtdemo.entity.Ingredient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RecipeResponse {
    String name;
    String description;
    Recipe.Status mealType;
    Double price;


    public RecipeResponse(Recipe recipe) {
        this.name = recipe.getName();
        this.mealType= recipe.getMealType();
        this.description = recipe.getDescription();
        this.price = recipe.getPrice();
    }

    public static List<RecipeResponse> getRecipesFromEntities(List<Recipe> recipes){
        return recipes.stream().map(recipe-> new RecipeResponse(recipe)).collect(Collectors.toList());
    }
}
