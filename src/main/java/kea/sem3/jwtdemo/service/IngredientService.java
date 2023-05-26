package kea.sem3.jwtdemo.service;

import kea.sem3.jwtdemo.dto.*;
import kea.sem3.jwtdemo.entity.Ingredient;
import kea.sem3.jwtdemo.error.Client4xxException;
import kea.sem3.jwtdemo.repositories.RecipeRepository;
import kea.sem3.jwtdemo.repositories.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {

    IngredientRepository ingredientRepository;
    RecipeRepository recipeRepository;

    public IngredientService(IngredientRepository ingredientRepository, RecipeRepository recipeRepository) {
        this.ingredientRepository = ingredientRepository;
        this.recipeRepository = recipeRepository;
    }

    public IngredientResponse getIngredient(int id){
        Ingredient ingredient = ingredientRepository.findById(id).orElseThrow(()-> new Client4xxException("No ingredient with reservation id:" + id));
        return new IngredientResponse(ingredient);
    }

    public List<IngredientResponse> getAllIngredients(){
        return IngredientResponse.getIngredientsFromEntities(ingredientRepository.findAll());
    }

   /* public IngredientResponse createIngredient(IngredientRequest ingredientRequest){
    Recipe recipe = recipeRepository.findById(ingredientRequest.getRecipeId()).orElseThrow();


    IngredientResponse ingredientResponse = new IngredientResponse(ingredient);

    return showingResponse;

    }*/

}
