package com.armanaj.computershop.model.products;

import com.armanaj.computershop.model.products.productBaseInfo.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Motherboard extends Product {

    public Motherboard() {
    }

    public Motherboard(String name, Brand brand, String model, Double price, String imageUrl, Category category,
                       Integer warrantyYears, Socket socket, MotherboardFormFactor formFactor, com.armanaj.computershop.model.products.productBaseInfo.PCIEVersion PCIEVersion) {
        super(name, brand, model, price, imageUrl, category, warrantyYears);
        this.socket = socket;
        this.formFactor = formFactor;
        this.PCIEVersion = PCIEVersion;
    }

    @ManyToOne
    @Getter
    @Setter
    private Socket socket;

    @ManyToOne
    @Getter
    @Setter
    private MotherboardFormFactor formFactor;

    @ManyToOne
    @Getter
    @Setter
    private PCIEVersion PCIEVersion;

}
