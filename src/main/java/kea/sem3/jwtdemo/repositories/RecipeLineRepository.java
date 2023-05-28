package kea.sem3.jwtdemo.repositories;

import kea.sem3.jwtdemo.entity.RecipeLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeLineRepository  extends JpaRepository<RecipeLine, Integer> {
    }
