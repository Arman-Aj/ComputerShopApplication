package com.armanaj.computershop.model.products;

import com.armanaj.computershop.model.products.productBaseInfo.Brand;
import com.armanaj.computershop.model.products.productBaseInfo.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {

    public Product() {
    }

    public Product(String name, Brand brand, String model, Double price, String imageUrl, Category category, Integer warrantyYears) {
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.imageUrl = imageUrl;
        this.category = category;
        this.warrantyYears = warrantyYears;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Getter
    private Integer id;

    @Getter
    @Setter
    private String name;

    @ManyToOne
    @Getter
    @Setter
    private Brand brand;

    @Getter
    @Setter
    private String model;

    @Getter
    @Setter
    private Double price;

    @Getter
    @Setter
    private String imageUrl;

    @ManyToOne
    @Getter
    @Setter
    private Category category;

    @Getter
    @Setter
    private Integer warrantyYears;

}
