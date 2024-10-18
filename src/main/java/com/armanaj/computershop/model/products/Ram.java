package com.armanaj.computershop.model.products;

import com.armanaj.computershop.model.products.productBaseInfo.Brand;
import com.armanaj.computershop.model.products.productBaseInfo.Category;
import com.armanaj.computershop.model.products.productBaseInfo.PCIEVersion;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Ram extends Product {

    public Ram() {
    }

    public Ram(String name, Brand brand, String model, Double price, String imageUrl, Category category,
               Integer warrantyYears, com.armanaj.computershop.model.products.productBaseInfo.PCIEVersion PCIEVersion,
               Integer clockSpeed, Integer capacity, Integer stickCount, Integer latency) {
        super(name, brand, model, price, imageUrl, category, warrantyYears);
        this.PCIEVersion = PCIEVersion;
        this.clockSpeed = clockSpeed;
        this.capacity = capacity;
        this.stickCount = stickCount;
        this.latency = latency;
    }

    @ManyToOne
    @Getter
    @Setter
    private PCIEVersion PCIEVersion;

    @Getter
    @Setter
    private Integer clockSpeed;

    @Getter
    @Setter
    private Integer capacity;

    @Getter
    @Setter
    private Integer stickCount;

    @Getter
    @Setter
    private Integer latency;


}
