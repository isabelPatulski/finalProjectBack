package kea.sem3.finalProject.api;

import kea.sem3.finalProject.dto.RecipeLineRequest;
import kea.sem3.finalProject.dto.RecipeLineResponse;
import kea.sem3.finalProject.service.RecipeLineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/recipeLines")
public class RecipeLineController {
    RecipeLineService recipeLineService;

    public RecipeLineController(RecipeLineService recipeLineService) {
        this.recipeLineService = recipeLineService;
    }

    @GetMapping
    public List<RecipeLineResponse> getAllRecipesLines(){
        return recipeLineService.getAllRecipeLines();
    }


    @GetMapping("/{id}")
    public RecipeLineResponse getRecipeLine(@PathVariable int id) throws Exception {
        return recipeLineService.getRecipeLine(id);
    }

    @PostMapping
    public RecipeLineResponse addRecipeLine(@RequestBody RecipeLineRequest body){
        return recipeLineService.addRecipeLine(body);
    }

    @DeleteMapping("/{id}")
    public void deleteRecipeLine(@PathVariable int id){
        recipeLineService.deleteRecipeLine(id);
    }
}
