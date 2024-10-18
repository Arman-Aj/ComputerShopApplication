package com.armanaj.computershop.controller;

import com.armanaj.computershop.model.products.productBaseInfo.Brand;
import com.armanaj.computershop.model.products.productBaseInfo.CPUGeneration;
import com.armanaj.computershop.model.products.productBaseInfo.GPUGeneration;
import com.armanaj.computershop.payload.request.BuildRequest;
import com.armanaj.computershop.payload.response.BuildResponse;
import com.armanaj.computershop.service.BuilderService;
import com.armanaj.computershop.service.products.productBaseInfo.BrandService;
import com.armanaj.computershop.service.products.productBaseInfo.CPUGenerationService;
import com.armanaj.computershop.service.products.productBaseInfo.GPUGenerationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600, allowCredentials = "true")
@RestController
@RequestMapping("/builder")
public class BuilderController {

    private final BuilderService builderService;
    private final BrandService brandService;
    private final GPUGenerationService gpuGenerationService;
    private final CPUGenerationService cpuGenerationService;

    Integer br_nvidia = 1;
    Integer br_amd = 2;
    Integer br_intel = 3;
    Integer gp_gf20 = 1;
    Integer gp_gf30 = 2;
    Integer gp_gf40 = 3;
    Integer gp_rd5000 = 4;
    Integer gp_rd6000 = 5;
    Integer gp_rd7000 = 6;
    Integer cp_10 = 1;
    Integer cp_11 = 2;
    Integer cp_12 = 3;
    Integer cp_13 = 4;
    Integer cp_z2 = 5;
    Integer cp_z3 = 6;
    Integer cp_z4 = 7;

    public BuilderController(BuilderService builderService, BrandService brandService, GPUGenerationService gpuGenerationService, CPUGenerationService cpuGenerationService) {
        this.builderService = builderService;
        this.brandService = brandService;
        this.gpuGenerationService = gpuGenerationService;
        this.cpuGenerationService = cpuGenerationService;
    }

    @GetMapping("/gpu-brand")
    public ResponseEntity<?> getGPUBrands() {
        List<Brand> brandList = new ArrayList<>();
        brandList.add(brandService.getBrandById(br_nvidia));
        brandList.add(brandService.getBrandById(br_amd));
        return ResponseEntity.ok(brandList);
    }

    @GetMapping("/cpu-brand")
    public ResponseEntity<?> getCPUBrands() {
        List<Brand> brandList = new ArrayList<>();
        brandList.add(brandService.getBrandById(br_intel));
        brandList.add(brandService.getBrandById(br_amd));
        return ResponseEntity.ok(brandList);
    }

    @GetMapping("/gpu-generation")
    public ResponseEntity<?> getGPUGenerations(@RequestParam(defaultValue = "0") Integer brand) {
        List<GPUGeneration> generationList = new ArrayList<>();
        if (Objects.equals(brand, br_nvidia)) {
            generationList.add(gpuGenerationService.getGPUGenerationById(gp_gf40));
            generationList.add(gpuGenerationService.getGPUGenerationById(gp_gf30));
            generationList.add(gpuGenerationService.getGPUGenerationById(gp_gf20));
        }
        if (Objects.equals(brand, br_amd)) {
            generationList.add(gpuGenerationService.getGPUGenerationById(gp_rd7000));
            generationList.add(gpuGenerationService.getGPUGenerationById(gp_rd6000));
            generationList.add(gpuGenerationService.getGPUGenerationById(gp_rd5000));
        }
        return ResponseEntity.ok(generationList);
    }

    @GetMapping("/cpu-generation")
    public ResponseEntity<?> getCPUGenerations(@RequestParam(defaultValue = "0") Integer brand) {
        List<CPUGeneration> generationList = new ArrayList<>();
        if (Objects.equals(brand, br_intel)) {
            generationList.add(cpuGenerationService.getCPUGenerationById(cp_13));
            generationList.add(cpuGenerationService.getCPUGenerationById(cp_12));
            generationList.add(cpuGenerationService.getCPUGenerationById(cp_11));
            generationList.add(cpuGenerationService.getCPUGenerationById(cp_10));
        }
        if (Objects.equals(brand, br_amd)) {
            generationList.add(cpuGenerationService.getCPUGenerationById(cp_z4));
            generationList.add(cpuGenerationService.getCPUGenerationById(cp_z3));
            generationList.add(cpuGenerationService.getCPUGenerationById(cp_z2));
        }
        return ResponseEntity.ok(generationList);
    }



    @PostMapping("/build")
    public ResponseEntity<BuildResponse> buildComputer(@RequestBody BuildRequest request) {
        return ResponseEntity.ok(builderService.build(request));
    }
}
