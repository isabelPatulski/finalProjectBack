package kea.sem3.jwtdemo.configuration;

import kea.sem3.jwtdemo.entity.Ingredient;
import kea.sem3.jwtdemo.repositories.*;
;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

@Controller
@Profile("!test")
public class MakeTestData implements ApplicationRunner {



    //RecipeRepository movieRepository;
    IngredientRepository ingredientRepository;


    public MakeTestData(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
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

    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        ingredientRepository.deleteAll();
        makePlainTestData();


    }
}
