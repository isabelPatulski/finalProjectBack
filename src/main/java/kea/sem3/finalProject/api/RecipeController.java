package kea.sem3.finalProject.api;

import kea.sem3.finalProject.dto.RecipeRequest;
import kea.sem3.finalProject.dto.RecipeResponse;
import kea.sem3.finalProject.service.RecipeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/recipes")
public class RecipeController {
        RecipeService recipeService;

        public RecipeController(RecipeService recipeService) {
            this.recipeService = recipeService;
        }

        @GetMapping
        public List<RecipeResponse> getRecipes(){
            return recipeService.getRecipes();
        }

        @GetMapping("/{id}")
        public RecipeResponse getRecipe(@PathVariable String id) throws Exception {
            return recipeService.getRecipe(id);
        }

        @PostMapping
        public RecipeResponse addRecipe(@RequestBody RecipeRequest body){
            return recipeService.addRecipe(body);
        }

        @PutMapping("/{id}")
        public RecipeResponse editRecipe(@RequestBody RecipeRequest body, @PathVariable String id){
            return recipeService.editRecipe(body,id);
        }


        @DeleteMapping("/{id}")
        public void deleteRecipe(@PathVariable String id){
            recipeService.deleteRecipe(id);
        }

    }
