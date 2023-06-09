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
        i1.setName("Spaghetti");
        i1.setPrice(0.02);
        i1.setMeasureType(Ingredient.MeasurementType.GRAM);
        ingredientRepository.save(i1);

        Ingredient i2 = new Ingredient();
        i2.setName("Olive oil");
        i2.setPrice(1.05);
        i1.setMeasureType(Ingredient.MeasurementType.TBSP);
        ingredientRepository.save(i2);

        Ingredient i3 = new Ingredient();
        i3.setName("Garlic clove");
        i3.setPrice(0.5);
        i3.setMeasureType(Ingredient.MeasurementType.PCS);
        ingredientRepository.save(i3);

        Ingredient i4 = new Ingredient();
        i4.setName("Parmigiano-Reggiano");
        i4.setPrice(0.4);
        i4.setMeasureType(Ingredient.MeasurementType.GRAM);
        ingredientRepository.save(i4);

        //Recipes

        Recipe r1 = new Recipe();
        r1.setName("Pasta aglio olio");
        r1.setDescription("1. Boil the spaghetti.\n" +
                "\n" +
                "2. Toast the garlic in olive oil.\n" +
                "\n" +
                "3. Stir the seasonings into the pasta, then stir in the garlic and oil. \n" +
                "\n" +
                "4. Toss with cheese. .\n");
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
        rl1.setRecipeName(r1.getName());
        rl1.setIngredientName(i1.getName());
        rl1.setAmount(450);
        recipeLineRepository.save(rl1);

        RecipeLine rl2 = new RecipeLine();
        rl2.setRecipeName(r1.getName());
        rl2.setIngredientName(i2.getName());
        rl2.setAmount(16);
        recipeLineRepository.save(rl2);

        RecipeLine rl3 = new RecipeLine();
        rl3.setRecipeName(r1.getName());
        rl3.setIngredientName(i3.getName());
        rl3.setAmount(6);
        recipeLineRepository.save(rl3);

        RecipeLine rl4 = new RecipeLine();
        rl4.setRecipeName(r1.getName());
        rl4.setIngredientName(i4.getName());
        rl4.setAmount(250);
        recipeLineRepository.save(rl4);

    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        ingredientRepository.deleteAll();
        makePlainTestData();


    }
}
