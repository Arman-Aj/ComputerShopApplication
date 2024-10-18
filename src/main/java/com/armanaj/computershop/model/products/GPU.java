package com.armanaj.computershop.model.products;

import com.armanaj.computershop.model.products.productBaseInfo.Brand;
import com.armanaj.computershop.model.products.productBaseInfo.Category;
import com.armanaj.computershop.model.products.productBaseInfo.GPUGeneration;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class GPU extends Product {

    public GPU() {
    }

    public GPU(String name, Brand brand, String model, Double price, String imageUrl, Category category,
               Integer warrantyYears, Integer videoMemorySize, Integer powerDraw,
               Integer directXVersion, GPUGeneration generation, Brand chipsetBrand) {
        super(name, brand, model, price, imageUrl, category, warrantyYears);
        this.videoMemorySize = videoMemorySize;
        this.powerDraw = powerDraw;
        this.directXVersion = directXVersion;
        this.generation = generation;
        this.chipsetBrand = chipsetBrand;
    }

    @Getter
    @Setter
    private Integer videoMemorySize;

    @Getter
    @Setter
    private Integer powerDraw;

    @Getter
    @Setter
    private Integer directXVersion;

    @ManyToOne
    @Getter
    @Setter
    private GPUGeneration generation;

    @ManyToOne
    @Getter
    @Setter
    private Brand chipsetBrand;


}
