package com.armanaj.computershop.payload.request;

import lombok.Getter;
import lombok.Setter;

public class BuildRequest {

    public BuildRequest(Double budget, Integer gpuChipsetBrand, Integer cpuBrand,
                        Integer gpuGeneration, Integer cpuGeneration, Integer formFactor, Integer powerRating,
                        Integer ramCapacity, Integer storageDriveType, Integer storageDriveCapacity, Double cpuPercentage,
                        Double gpuPercentage, Double casePercentage, Double motherboardPercentage, Double powerSupplyPercentage,
                        Double ramPercentage, Double storageDrivePercentage) {
        this.budget = budget;
        this.gpuChipsetBrand = gpuChipsetBrand;
        this.cpuBrand = cpuBrand;
        this.gpuGeneration = gpuGeneration;
        this.cpuGeneration = cpuGeneration;
        this.formFactor = formFactor;
        this.powerRating = powerRating;
        this.ramCapacity = ramCapacity;
        this.storageDriveType = storageDriveType;
        this.storageDriveCapacity = storageDriveCapacity;
        this.cpuPercentage = cpuPercentage;
        this.gpuPercentage = gpuPercentage;
        this.casePercentage = casePercentage;
        this.motherboardPercentage = motherboardPercentage;
        this.powerSupplyPercentage = powerSupplyPercentage;
        this.ramPercentage = ramPercentage;
        this.storageDrivePercentage = storageDrivePercentage;
    }

    public BuildRequest() {
    }

    @Getter
    @Setter
    private Double budget;

    @Getter
    @Setter
    private Integer gpuChipsetBrand;

    @Getter
    @Setter
    private Integer cpuBrand;

    @Getter
    @Setter
    private Integer gpuGeneration;

    @Getter
    @Setter
    private Integer cpuGeneration;

    @Getter
    @Setter
    private Integer formFactor;

    @Getter
    @Setter
    private Integer powerRating;

    @Getter
    @Setter
    private Integer ramCapacity;

    @Getter
    @Setter
    private Integer storageDriveType;

    @Getter
    @Setter
    private Integer storageDriveCapacity;

    @Getter
    @Setter
    private Double cpuPercentage;

    @Getter
    @Setter
    private Double gpuPercentage;

    @Getter
    @Setter
    private Double casePercentage;

    @Getter
    @Setter
    private Double motherboardPercentage;

    @Getter
    @Setter
    private Double powerSupplyPercentage;

    @Getter
    @Setter
    private Double ramPercentage;

    @Getter
    @Setter
    private Double storageDrivePercentage;
}
