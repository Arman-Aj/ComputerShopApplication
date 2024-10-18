package com.armanaj.computershop.model.products;

import com.armanaj.computershop.model.products.productBaseInfo.Brand;
import com.armanaj.computershop.model.products.productBaseInfo.Category;
import com.armanaj.computershop.model.products.productBaseInfo.PowerRating;
import com.armanaj.computershop.model.products.productBaseInfo.PowerSupplyFormFactor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class PowerSupply extends Product {

    public PowerSupply() {
    }

    public PowerSupply(String name, Brand brand, String model, Double price, String imageUrl, Category category, Integer warrantyYears,
                       Integer wattage, PowerRating powerRating, PowerSupplyFormFactor powerSupplyFormFactor) {
        super(name, brand, model, price, imageUrl, category, warrantyYears);
        this.wattage = wattage;
        this.powerRating = powerRating;
        this.powerSupplyFormFactor = powerSupplyFormFactor;
    }

    @Getter
    @Setter
    private Integer wattage;

    @ManyToOne
    @Getter
    @Setter
    private PowerRating powerRating;

    @ManyToOne
    @Getter
    @Setter
    private PowerSupplyFormFactor powerSupplyFormFactor;

}
