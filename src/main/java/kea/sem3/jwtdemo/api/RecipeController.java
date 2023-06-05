package kea.sem3.jwtdemo.api;

import kea.sem3.jwtdemo.dto.RecipeRequest;
import kea.sem3.jwtdemo.dto.RecipeResponse;
import kea.sem3.jwtdemo.service.RecipeService;
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

        @PatchMapping ("/{id}/{newName}")
        public void editName(@PathVariable String id,@PathVariable String newName) throws Exception {
            recipeService.updateName(id,newName);
        }
        @PatchMapping ("/{id}/{newDescription}")
        public void editDescription(@PathVariable String id,@PathVariable String newDescription) throws Exception {
            recipeService.updateDescription(id,newDescription);
        }

        @DeleteMapping("/{id}")
        public void deleteRecipe(@PathVariable String id){
            recipeService.deleteRecipe(id);
        }

    }
