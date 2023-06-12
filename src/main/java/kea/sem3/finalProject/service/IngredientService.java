package kea.sem3.finalProject.service;

import kea.sem3.finalProject.dto.*;
import kea.sem3.finalProject.entity.Ingredient;
import kea.sem3.finalProject.error.Client4xxException;
import kea.sem3.finalProject.repositories.RecipeRepository;
import kea.sem3.finalProject.repositories.IngredientRepository;
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

    public IngredientResponse getIngredient(String id){
        Ingredient ingredient = ingredientRepository.findById(id).orElseThrow(()-> new Client4xxException("No ingredient with id:" + id));
        return new IngredientResponse(ingredient);
    }

    public List<IngredientResponse> getAllIngredients(){
        return IngredientResponse.getIngredientsFromEntities(ingredientRepository.findAll());
    }

    public IngredientResponse addIngredient(IngredientRequest body){
        Ingredient newIngredient = ingredientRepository.save(new Ingredient(body));
        return new IngredientResponse(newIngredient);
    }

    public void deleteIngredient (String name) {
        Ingredient ingredientToDelete = ingredientRepository.findById(name).orElseThrow(()-> new Client4xxException("No ingredient with id:" + name));
        ingredientRepository.delete(ingredientToDelete);
    }

}
