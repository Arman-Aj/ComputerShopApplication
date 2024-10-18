package com.armanaj.computershop.service.products;

import com.armanaj.computershop.exception.BuildProductNotFoundException;
import com.armanaj.computershop.model.products.GPU;
import com.armanaj.computershop.payload.response.ProductResponse;
import com.armanaj.computershop.repository.products.GPURepository;
import com.armanaj.computershop.service.products.productBaseInfo.BrandService;
import com.armanaj.computershop.service.products.productBaseInfo.CategoryService;
import com.armanaj.computershop.service.products.productBaseInfo.GPUGenerationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class GPUService {

    private final GPURepository gpuRepository;

    private final CategoryService categoryService;

    private final BrandService brandService;

    private final GPUGenerationService gpuGenerationService;

    public GPUService(GPURepository gpuRepository, CategoryService categoryService, BrandService brandService, GPUGenerationService gpuGenerationService) {
        this.gpuRepository = gpuRepository;
        this.categoryService = categoryService;
        this.brandService = brandService;
        this.gpuGenerationService = gpuGenerationService;
    }

    public ProductResponse<GPU> getAllGPUs(int pageNumber, String searchText) {
        Page<GPU> page = Objects.equals(searchText, "") ? findAllGPUs(pageNumber) : findGPUsBySearch(pageNumber, searchText);
        return new ProductResponse<>(page.getNumber(), page.getTotalPages(), page.getContent());
    }

    public List<GPU> findGPUsForBuilder(Double price, Integer chipsetBrand, Integer generation) throws BuildProductNotFoundException {
            List<GPU> gpuList = gpuRepository.findGPUSByPriceLessThanEqualAndChipsetBrandIdEqualsAndGenerationIdEquals(price, chipsetBrand, generation, Sort.by(Sort.Direction.DESC, "price"));
        if (gpuList.size() == 0) {
            gpuList = gpuRepository.findGPUSByPriceGreaterThanAndChipsetBrandIdEqualsAndGenerationIdEquals(price, chipsetBrand, generation, Sort.by(Sort.Direction.ASC, "price"));
        }
        if (gpuList.size() == 0) {
            throw new BuildProductNotFoundException();
        }
        return gpuList;
    }

    public GPU save(String name, Integer brand, String model, Double price, String imageUrl, Integer category,
                    Integer warrantyYears, Integer videoMemorySize, Integer powerDraw,
                    Integer directXVersion, Integer gpuGeneration, Integer chipsetBrand) {
        GPU gpu = new GPU(name, brandService.getBrandById(brand), model, price, imageUrl, categoryService.getCategoryById(category),
                warrantyYears, videoMemorySize, powerDraw, directXVersion,
                gpuGenerationService.getGPUGenerationById(gpuGeneration), brandService.getBrandById(chipsetBrand));
        return gpuRepository.save(gpu);
    }

    private Page<GPU> findAllGPUs(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 10, Sort.by("price"));
        return gpuRepository.findAll(pageable);
    }

    private Page<GPU> findGPUsBySearch(int pageNumber, String searchText) {
        Pageable pageable = PageRequest.of(pageNumber, 10, Sort.by("price"));
        return gpuRepository
                .findGPUsByNameIgnoreCaseContainingOrBrandNameIgnoreCaseContainingOrModelIgnoreCaseContaining(searchText, searchText, searchText, pageable);
    }
}
