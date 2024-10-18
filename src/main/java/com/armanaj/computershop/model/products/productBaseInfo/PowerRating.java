package com.armanaj.computershop.model.products.productBaseInfo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class PowerRating {

    public PowerRating() {
    }

    public PowerRating(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @Getter
    private Integer id;

    @Getter
    @Setter
    private String name;
}
