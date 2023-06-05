package kea.sem3.jwtdemo.configuration;

import kea.sem3.jwtdemo.entity.Ingredient;
import kea.sem3.jwtdemo.entity.Recipe;
import kea.sem3.jwtdemo.entity.RecipeLine;
import kea.sem3.jwtdemo.repositories.*;
;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

@Controller
@Profile("!test")
public class MakeTestData implements ApplicationRunner {



    RecipeRepository recipeRepository;
    IngredientRepository ingredientRepository;
    RecipeLineRepository recipeLineRepository;


    public MakeTestData(IngredientRepository ingredientRepository, RecipeRepository recipeRepository, RecipeLineRepository recipeLineRepository) {
        this.ingredientRepository = ingredientRepository;
        this.recipeRepository = recipeRepository;
        this.recipeLineRepository = recipeLineRepository;
    }

    public  void makePlainTestData() {


//Ingredients

        Ingredient i1 = new Ingredient();
        i1.setName("Mel");
        i1.setPrice(10);
        ingredientRepository.save(i1);

        Ingredient i2 = new Ingredient();
        i2.setName("Salt");
        i2.setPrice(15);
        ingredientRepository.save(i2);

        Ingredient i3 = new Ingredient();
        i3.setName("Sukker");
        i3.setPrice(15);
        ingredientRepository.save(i3);

        Ingredient i4 = new Ingredient();
        i4.setName("Æg");
        i4.setPrice(20);
        ingredientRepository.save(i4);

        //Recipes

        Recipe r1 = new Recipe();
        r1.setName("Lasagne");
        r1.setDescription("Lækker lasagne");
        r1.setMealType(Recipe.Status.Dinner);
        recipeRepository.save(r1);

        Recipe r2 = new Recipe();
        r2.setName("Boller i karry");
        r2.setDescription("Smager godt");
        r2.setMealType(Recipe.Status.Dinner);
        recipeRepository.save(r2);

        Recipe r3 = new Recipe();
        r3.setName("Havregrød");
        r3.setDescription("Lidt meh");
        r3.setMealType(Recipe.Status.Breakfast);
        recipeRepository.save(r3);

        //RecipeLine
        RecipeLine rl1 = new RecipeLine();
        rl1.setRecipe(r2);
        rl1.setIngredient(i2);
        rl1.setMeasureType(RecipeLine.MeasurementType.CUP);
        rl1.setAmount(1);
        recipeLineRepository.save(rl1);

        RecipeLine rl2 = new RecipeLine();
        rl2.setRecipe(r2);
        rl2.setIngredient(i3);
        rl2.setMeasureType(RecipeLine.MeasurementType.GRAM);
        rl2.setAmount(300);
        recipeLineRepository.save(rl2);

        RecipeLine rl3 = new RecipeLine();
        rl3.setRecipe(r2);
        rl3.setIngredient(i1);
        rl3.setMeasureType(RecipeLine.MeasurementType.LITER);
        rl3.setAmount(0.5);
        recipeLineRepository.save(rl3);

        RecipeLine rl4 = new RecipeLine();
        rl4.setRecipe(r3);
        rl4.setIngredient(i3);
        rl4.setMeasureType(RecipeLine.MeasurementType.GRAM);
        rl4.setAmount(400);
        recipeLineRepository.save(rl4);

        RecipeLine rl5 = new RecipeLine();
        rl5.setRecipe(r3);
        rl5.setIngredient(i4);
        rl5.setMeasureType(RecipeLine.MeasurementType.PCS);
        rl5.setAmount(2);
        recipeLineRepository.save(rl5);
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        ingredientRepository.deleteAll();
        makePlainTestData();


    }
}
