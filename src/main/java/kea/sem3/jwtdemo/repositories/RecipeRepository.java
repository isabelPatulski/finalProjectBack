package kea.sem3.jwtdemo.repositories;

import kea.sem3.jwtdemo.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

}
