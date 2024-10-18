package com.armanaj.computershop.service.products.productBaseInfo;

import com.armanaj.computershop.model.products.productBaseInfo.CPUGeneration;
import com.armanaj.computershop.repository.products.productBaseInfo.CPUGenerationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CPUGenerationService {

    private final CPUGenerationRepository cpuGenerationRepository;

    public CPUGenerationService(CPUGenerationRepository cpuGenerationRepository) {
        this.cpuGenerationRepository = cpuGenerationRepository;
    }

    public List<CPUGeneration> getAllCPUGenerations() {
        return cpuGenerationRepository.findAll().stream().toList();
    }

    public CPUGeneration getCPUGenerationById(Integer id) {
        return cpuGenerationRepository.findById(id).orElseThrow();
    }

    public CPUGeneration save(String name) {
        CPUGeneration cpuGeneration = new CPUGeneration(name);
        return cpuGenerationRepository.save(cpuGeneration);
    }
}
