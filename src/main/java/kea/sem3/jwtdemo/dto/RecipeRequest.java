package kea.sem3.jwtdemo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kea.sem3.jwtdemo.entity.Recipe;
import kea.sem3.jwtdemo.entity.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecipeRequest {
    private String name;
    private String description;
    private Recipe.Status mealType;

    @JsonIgnore
    private Set<Ingredient> showings;
}
