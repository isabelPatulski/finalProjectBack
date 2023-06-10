package kea.sem3.jwtdemo.entity;


import kea.sem3.jwtdemo.dto.RecipeRequest;
import lombok.*;

import javax.persistence.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter @Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Recipe {
    @Id
    @Column(length = 60)
    String name;

    @Enumerated(EnumType.ORDINAL)
    Status mealType;

    @Column(length = 500)
    String description;


    @Column(insertable = false, updatable = false)
    Double price;

    public Recipe(String name, String description, Status mealType) {
        this.name = name;
        this.mealType = mealType;
        this.description = description;
    }

    public Recipe(RecipeRequest body){
        this.name = body.getName();
        this.description = body.getDescription();
        this.mealType = body.getMealType();
    }
    public enum Status {
        Breakfast, Lunch, Dinner, Dessert;
    }

    public double getPrice(){
        Double ret = 0.0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/finalProject","root","12345678");
            Statement stmt=con.createStatement();
            String sql = "SELECT SUM(recipe_line.amount*ingredient.price) FROM finalProject.recipe_line\n" +
                    "inner join finalProject.ingredient \n" +
                    "on ingredient.name = recipe_line.ingredient_name\n" +
                    "AND  recipe_line.recipe_name = '"+this.name+"'";
            ResultSet rs=stmt.executeQuery(sql);
            if (rs.next()) {
                ret = rs.getDouble(1);
            }
            con.close();
        }catch(Exception e){ System.out.println(e);}
        return ret;
    }


}
