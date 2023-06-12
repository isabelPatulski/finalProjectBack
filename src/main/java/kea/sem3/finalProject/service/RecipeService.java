package kea.sem3.finalProject.service;

import kea.sem3.finalProject.dto.RecipeRequest;
import kea.sem3.finalProject.dto.RecipeResponse;
import kea.sem3.finalProject.entity.Recipe;
import kea.sem3.finalProject.error.Client4xxException;
import kea.sem3.finalProject.repositories.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RecipeService {
        RecipeRepository recipeRepository;

        public RecipeService(RecipeRepository recipeRepository) {
            this.recipeRepository = recipeRepository;
        }

        public List<RecipeResponse> getRecipes(){
            List<Recipe> recipes =  recipeRepository.findAll();
            return RecipeResponse.getRecipesFromEntities(recipes);
        }
        public RecipeResponse getRecipe(String id) throws Exception {
            Recipe recipe = recipeRepository.findById(id).orElseThrow(()->new Client4xxException("No recipe with this id exists"));
            return new RecipeResponse(recipe);
        }
        public RecipeResponse addRecipe(RecipeRequest body){
            Recipe newRecipe = recipeRepository.save(new Recipe(body));
            return new RecipeResponse(newRecipe);
        }
        public RecipeResponse editRecipe(RecipeRequest recipeToEdit, String recipeId){
            Recipe recipe = recipeRepository.findById(recipeId).orElseThrow(()-> new Client4xxException("No recipe with provided ID found"));
            recipe.setDescription(recipeToEdit.getDescription());
            recipe.setMealType(recipeToEdit.getMealType());
            return new RecipeResponse(recipeRepository.save(recipe));
        }

        public void deleteRecipe(String recipeId) {
            recipeRepository.deleteById(recipeId);
        }
    }