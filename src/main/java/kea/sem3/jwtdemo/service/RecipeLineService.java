package kea.sem3.jwtdemo.service;

import kea.sem3.jwtdemo.dto.RecipeLineRequest;
import kea.sem3.jwtdemo.dto.RecipeLineResponse;
import kea.sem3.jwtdemo.entity.RecipeLine;
import kea.sem3.jwtdemo.error.Client4xxException;
import kea.sem3.jwtdemo.repositories.RecipeLineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeLineService {
    RecipeLineRepository recipeLineRepository;

    public RecipeLineService(RecipeLineRepository recipeLineRepository) {
        this.recipeLineRepository = recipeLineRepository;
    }


    public List<RecipeLineResponse> getAllRecipeLines(){
        return RecipeLineResponse.getRecipeLinesFromEntities(recipeLineRepository.findAll());
    }
    public RecipeLineResponse getRecipeLine(int id) throws Exception {
        RecipeLine recipeLine = recipeLineRepository.findById(id).orElseThrow(()->new Client4xxException("No recipeLine with this id exists"));
        return new RecipeLineResponse(recipeLine);
    }
    public RecipeLineResponse addRecipeLine(RecipeLineRequest body){
        RecipeLine newRecipeLine = recipeLineRepository.save(new RecipeLine(body));
        return new RecipeLineResponse(newRecipeLine);
    }

    public void deleteRecipeLine(int recipeLineId) {
        recipeLineRepository.deleteById(recipeLineId);
    }

}

