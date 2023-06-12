package kea.sem3.finalProject.repositories;

import kea.sem3.finalProject.entity.RecipeLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeLineRepository  extends JpaRepository<RecipeLine, Integer> {
    }
