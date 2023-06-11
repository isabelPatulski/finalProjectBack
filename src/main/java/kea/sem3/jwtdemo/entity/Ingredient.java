package kea.sem3.jwtdemo.entity;

import kea.sem3.jwtdemo.dto.IngredientRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;


@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Ingredient {

    @Id
    String name;

    @Column
    double price;

    @Enumerated(EnumType.STRING)
    private MeasurementType measureType;

    public Ingredient(String name, int price) {
        this.name = name;
        this.price = price;

    }

    public Ingredient(IngredientRequest body){
        this.measureType = body.getMeasurementType();
        this.name = body.getName();
        this.price = body.getPrice();
    }

    public enum MeasurementType {
        LITER,
        CUP,
        GRAM,
        PCS,
        TBS,
        TBSP,
    }


}
