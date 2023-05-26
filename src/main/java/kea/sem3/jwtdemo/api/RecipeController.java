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
            return recipeService.getMovies();
        }

        @GetMapping("/{id}")
        public RecipeResponse getRecipe(@PathVariable int id) throws Exception {
            return recipeService.getRecipe(id);
        }

        @PostMapping
        public RecipeResponse addRecipe(@RequestBody RecipeRequest body){
            return recipeService.addRecipe(body);
        }

        @PutMapping("/{id}")
        public RecipeResponse editRecipe(@RequestBody RecipeRequest body, @PathVariable int id){
            return recipeService.editRecipe(body,id);
        }

        @PatchMapping ("/{id}/{newName}")
        public void editName(@PathVariable int id,@PathVariable String newName) throws Exception {
            recipeService.updateName(id,newName);
        }
        @PatchMapping ("/{id}/{newDescription}")
        public void editDescription(@PathVariable int id,@PathVariable String newDescription) throws Exception {
            recipeService.updateDescription(id,newDescription);
        }

        @DeleteMapping("/{id}")
        public void deleteMovie(@PathVariable int id){}

    }
