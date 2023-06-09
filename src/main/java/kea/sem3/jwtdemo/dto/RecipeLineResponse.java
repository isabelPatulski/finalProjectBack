package kea.sem3.jwtdemo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import kea.sem3.jwtdemo.entity.Ingredient;
import kea.sem3.jwtdemo.entity.Recipe;
import kea.sem3.jwtdemo.entity.RecipeLine;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RecipeLineResponse {
    int id;
    Double amount;
    String ingredientName;
    String recipeName;


    public RecipeLineResponse(RecipeLine recipeLine){
        this.id=recipeLine.getId();
        this.amount=recipeLine.getAmount();
        this.id = recipeLine.getId();
        this.ingredientName = recipeLine.getIngredientName();
        this.recipeName = recipeLine.getRecipeName();
    }


    public static List<RecipeLineResponse> getRecipeLinesFromEntities(List<RecipeLine> recipeLines){
        return recipeLines.stream().map(recipeLine-> new RecipeLineResponse(recipeLine)).collect(Collectors.toList());
    }

}

