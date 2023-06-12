package kea.sem3.finalProject.configuration;

import kea.sem3.finalProject.entity.Ingredient;
import kea.sem3.finalProject.entity.Recipe;
import kea.sem3.finalProject.entity.RecipeLine;
import kea.sem3.finalProject.repositories.*;
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

        //______________________________________

        Ingredient i6 = new Ingredient();
        i6.setName("Strawberries");
        i6.setPrice(5);
        i6.setMeasureType(Ingredient.MeasurementType.CUP);
        ingredientRepository.save(i6);

        Ingredient i7 = new Ingredient();
        i7.setName("Mango");
        i7.setPrice(6.25);
        i7.setMeasureType(Ingredient.MeasurementType.CUP);
        ingredientRepository.save(i7);

        Ingredient i8 = new Ingredient();
        i8.setName("Banana");
        i8.setPrice(2);
        i8.setMeasureType(Ingredient.MeasurementType.PCS);
        ingredientRepository.save(i8);

        Ingredient i9 = new Ingredient();
        i9.setName("Coconut Water");
        i9.setPrice(7);
        i9.setMeasureType(Ingredient.MeasurementType.CUP);
        ingredientRepository.save(i9);

        //--------------------------------

        Ingredient i10 = new Ingredient();
        i10.setName("Egg");
        i10.setPrice(2);
        i10.setMeasureType(Ingredient.MeasurementType.PCS);
        ingredientRepository.save(i10);

        Ingredient i11 = new Ingredient();
        i11.setName("Basil");
        i11.setPrice(3);
        i11.setMeasureType(Ingredient.MeasurementType.TBSP);
        ingredientRepository.save(i11);

        Ingredient i12 = new Ingredient();
        i12.setName("Sun dried tomatoes");
        i12.setPrice(4);
        i12.setMeasureType(Ingredient.MeasurementType.TBSP);
        ingredientRepository.save(i12);

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
        r2.setName("Strawberry Mango Smoothie");
        r2.setDescription("Use frozen ingredients or add ice cubes. " +
                "Combine all of the ingredients in a high speed blender and blend until smooth. Enjoy!");
        r2.setMealType(Recipe.Status.Dessert);
        recipeRepository.save(r2);

        Recipe r3 = new Recipe();
        r3.setName("Italian Cloud Eggs");
        r3.setDescription("Preheat oven to 450°. Separate eggs; place whites in a large bowl and yolks in 4 " +
                "separate small bowls. Beat egg whites, Italian seasoning, salt and pepper until stiff peaks form.\n" +
                "drop eggs into a pan and mix. Sprinkle with cheese" +
                "Bake until light brown, about 5 minutes. Gently slip an egg yolk into each of the mounds. " +
                "Sprinkle with basil and tomatoes. Serve immediately.");
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
        //------------------------------

        RecipeLine rl5 = new RecipeLine();
        rl5.setRecipeName(r2.getName());
        rl5.setIngredientName(i6.getName());
        rl5.setAmount(1.5);
        recipeLineRepository.save(rl5);


        RecipeLine rl6 = new RecipeLine();
        rl6.setRecipeName(r2.getName());
        rl6.setIngredientName(i7.getName());
        rl6.setAmount(1);
        recipeLineRepository.save(rl6);

        RecipeLine rl7 = new RecipeLine();
        rl7.setRecipeName(r2.getName());
        rl7.setIngredientName(i8.getName());
        rl7.setAmount(1);
        recipeLineRepository.save(rl7);

        RecipeLine rl8 = new RecipeLine();
        rl8.setRecipeName(r2.getName());
        rl8.setIngredientName(i9.getName());
        rl8.setAmount(0.5);
        recipeLineRepository.save(rl8);

        //------------------------------

        RecipeLine rl9 = new RecipeLine();
        rl9.setRecipeName(r3.getName());
        rl9.setIngredientName(i10.getName());
        rl9.setAmount(4);
        recipeLineRepository.save(rl9);

        RecipeLine rl10 = new RecipeLine();
        rl10.setRecipeName(r3.getName());
        rl10.setIngredientName(i4.getName());
        rl10.setAmount(90);
        recipeLineRepository.save(rl10);

        RecipeLine rl11 = new RecipeLine();
        rl11.setRecipeName(r3.getName());
        rl11.setIngredientName(i12.getName());
        rl11.setAmount(1);
        recipeLineRepository.save(rl11);

        RecipeLine rl12 = new RecipeLine();
        rl12.setRecipeName(r3.getName());
        rl12.setIngredientName(i11.getName());
        rl12.setAmount(1);
        recipeLineRepository.save(rl12);



    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        ingredientRepository.deleteAll();
        makePlainTestData();


    }
}
