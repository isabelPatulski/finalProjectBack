package kea.sem3.jwtdemo.configuration;

import kea.sem3.jwtdemo.entity.Ingredient;
import kea.sem3.jwtdemo.entity.Recipe;
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


    public MakeTestData(IngredientRepository ingredientRepository, RecipeRepository recipeRepository) {
        this.ingredientRepository = ingredientRepository;
        this.recipeRepository = recipeRepository;
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

    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        ingredientRepository.deleteAll();
        makePlainTestData();


    }
}
