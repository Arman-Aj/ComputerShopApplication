package com.armanaj.computershop.model.products;

import com.armanaj.computershop.model.products.productBaseInfo.Brand;
import com.armanaj.computershop.model.products.productBaseInfo.Category;
import com.armanaj.computershop.model.products.productBaseInfo.MotherboardFormFactor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Case extends Product {

    public Case() {
    }

    public Case(String name, Brand brand, String model, Double price, String imageUrl, Category category, Integer warrantyYears, MotherboardFormFactor formFactor, Integer fanCount) {
        super(name, brand, model, price, imageUrl, category, warrantyYears);
        this.formFactor = formFactor;
        this.fanCount = fanCount;
    }

    @ManyToOne
    @Getter
    @Setter
    private MotherboardFormFactor formFactor;

    @Getter
    @Setter
    private Integer fanCount;


}
