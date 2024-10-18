package com.armanaj.computershop.service.products.productBaseInfo;

import com.armanaj.computershop.model.products.productBaseInfo.PowerSupplyFormFactor;
import com.armanaj.computershop.repository.products.productBaseInfo.PowerSupplyFormFactorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PowerSupplyFormFactorService {

    private final PowerSupplyFormFactorRepository powerSupplyFormFactorRepository;

    public PowerSupplyFormFactorService(PowerSupplyFormFactorRepository powerSupplyFormFactorRepository) {
        this.powerSupplyFormFactorRepository = powerSupplyFormFactorRepository;
    }

    public List<PowerSupplyFormFactor> getAllPowerSupplyFormFactors() {
        return powerSupplyFormFactorRepository.findAll().stream().toList();
    }

    public PowerSupplyFormFactor getPowerSupplyFormFactorById(Integer id) {
        return powerSupplyFormFactorRepository.findById(id).orElseThrow();
    }

    public PowerSupplyFormFactor save(String name) {
        PowerSupplyFormFactor powerSupplyFormFactor = new PowerSupplyFormFactor(name);
        return powerSupplyFormFactorRepository.save(powerSupplyFormFactor);
    }
}
