package com.armanaj.computershop.service.products.productBaseInfo;

import com.armanaj.computershop.model.products.productBaseInfo.MotherboardFormFactor;
import com.armanaj.computershop.repository.products.productBaseInfo.MotherboardFormFactorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotherboardFormFactorService {

    private final MotherboardFormFactorRepository motherboardFormFactorRepository;

    public MotherboardFormFactorService(MotherboardFormFactorRepository motherboardFormFactorRepository) {
        this.motherboardFormFactorRepository = motherboardFormFactorRepository;
    }

    public List<MotherboardFormFactor> getAllMotherboardFormFactors() {
        return motherboardFormFactorRepository.findAll().stream().toList();
    }

    public MotherboardFormFactor getMotherboardFormFactorById(Integer id) {
        return motherboardFormFactorRepository.findById(id).orElseThrow();
    }

    public MotherboardFormFactor save(String name) {
        MotherboardFormFactor motherboardFormFactor = new MotherboardFormFactor(name);
        return motherboardFormFactorRepository.save(motherboardFormFactor);
    }
}
