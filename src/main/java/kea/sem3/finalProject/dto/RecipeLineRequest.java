package kea.sem3.finalProject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecipeLineRequest {

    private double amount;

    public String recipeName;

    public String ingredientName;


}
