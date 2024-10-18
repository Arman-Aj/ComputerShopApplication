package com.armanaj.computershop.model.products;

import com.armanaj.computershop.model.products.productBaseInfo.Brand;
import com.armanaj.computershop.model.products.productBaseInfo.Category;
import com.armanaj.computershop.model.products.productBaseInfo.PCIEVersion;
import com.armanaj.computershop.model.products.productBaseInfo.StorageDriveType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class StorageDrive extends Product {

    public StorageDrive() {
    }

    public StorageDrive(String name, Brand brand, String model, Double price, String imageUrl, Category category,
                        Integer warrantyYears, Integer capacity, StorageDriveType storageDriveType, PCIEVersion pcieVersion) {
        super(name, brand, model, price, imageUrl, category, warrantyYears);
        this.capacity = capacity;
        this.storageDriveType = storageDriveType;
        this.pcieVersion = pcieVersion;
    }

    @Getter
    @Setter
    private Integer capacity;

    @ManyToOne
    @Getter
    @Setter
    private StorageDriveType storageDriveType;

    @ManyToOne
    @Getter
    @Setter
    private PCIEVersion pcieVersion;

}
