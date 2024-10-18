package com.armanaj.computershop.model.products;

import com.armanaj.computershop.model.products.productBaseInfo.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class CPU extends Product{

    public CPU() {
    }

    public CPU(String name, Brand brand, String model, Double price, String imageUrl, Category category,
               Integer warrantyYears, String architecture, com.armanaj.computershop.model.products.productBaseInfo.PCIEVersion PCIEVersion, Socket socket,
               Integer coreCount, Integer highPerformanceCoreCount, Double baseClock, Double maxClock, Integer powerDraw,
               CPUGeneration generation) {
        super(name, brand, model, price, imageUrl, category, warrantyYears);
        this.architecture = architecture;
        this.PCIEVersion = PCIEVersion;
        this.socket = socket;
        this.coreCount = coreCount;
        this.highPerformanceCoreCount = highPerformanceCoreCount;
        this.baseClock = baseClock;
        this.maxClock = maxClock;
        this.powerDraw = powerDraw;
        this.generation = generation;
    }

    @Getter
    @Setter
    private String architecture;

    @ManyToOne
    @Getter
    @Setter
    private PCIEVersion PCIEVersion;

    @ManyToOne
    @Getter
    @Setter
    private Socket socket;

    @Getter
    @Setter
    private Integer coreCount;

    @Getter
    @Setter
    private Integer highPerformanceCoreCount;

    @Getter
    @Setter
    private Double baseClock;

    @Getter
    @Setter
    private Double maxClock;

    @Getter
    @Setter
    private Integer powerDraw;

    @ManyToOne
    @Getter
    @Setter
    private CPUGeneration generation;


}
