package kea.sem3.jwtdemo.api;


import kea.sem3.jwtdemo.dto.IngredientRequest;
import kea.sem3.jwtdemo.dto.IngredientResponse;
import kea.sem3.jwtdemo.dto.RecipeRequest;
import kea.sem3.jwtdemo.dto.RecipeResponse;
import kea.sem3.jwtdemo.service.IngredientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/ingredients")
public class IngredientController {
    IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public List<IngredientResponse> getAllIngredients(){
        return ingredientService.getAllIngredients();
    }

    @GetMapping("/{name}")
    public IngredientResponse getIngredient(@PathVariable String name) throws Exception
    {
        return ingredientService.getIngredient(name);
    }

    @PostMapping
    public IngredientResponse addIngredient(@RequestBody IngredientRequest body){
        return ingredientService.addIngredient(body);
    }

    @DeleteMapping("/{name}")
    public void deleteIngredient(@PathVariable String name){
        ingredientService.deleteIngredient(name);
    }


}
