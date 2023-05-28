package kea.sem3.jwtdemo.api;


import kea.sem3.jwtdemo.dto.IngredientRequest;
import kea.sem3.jwtdemo.dto.IngredientResponse;
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

    @GetMapping("/{id}")
    public IngredientResponse getIngredient(@PathVariable int id) throws Exception
    {
        return ingredientService.getIngredient(id);
    }

}
