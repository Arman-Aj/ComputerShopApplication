package com.armanaj.computershop.service.products.productBaseInfo;

import com.armanaj.computershop.model.products.productBaseInfo.GPUGeneration;
import com.armanaj.computershop.repository.products.productBaseInfo.GPUGenerationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GPUGenerationService {

    private final GPUGenerationRepository gpuGenerationRepository;

    public GPUGenerationService(GPUGenerationRepository gpuGenerationRepository) {
        this.gpuGenerationRepository = gpuGenerationRepository;
    }

    public List<GPUGeneration> getAllGPUGenerations() {
        return gpuGenerationRepository.findAll().stream().toList();
    }

    public GPUGeneration getGPUGenerationById(Integer id) {
        return gpuGenerationRepository.findById(id).orElseThrow();
    }

    public GPUGeneration save(String name) {
        GPUGeneration gpuGeneration = new GPUGeneration(name);
        return gpuGenerationRepository.save(gpuGeneration);
    }
}
