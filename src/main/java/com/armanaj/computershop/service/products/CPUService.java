package com.armanaj.computershop.service.products;

import com.armanaj.computershop.exception.BuildProductNotFoundException;
import com.armanaj.computershop.model.products.CPU;
import com.armanaj.computershop.payload.response.ProductResponse;
import com.armanaj.computershop.repository.products.CPURepository;
import com.armanaj.computershop.service.products.productBaseInfo.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CPUService {

    private final CPURepository cpuRepository;

    private final CategoryService categoryService;

    private final PCIEVersionService pcieVersionService;

    private final SocketService socketService;

    private final CPUGenerationService cpuGenerationService;

    private final BrandService brandService;


    public CPUService(CPURepository cpuRepository, CategoryService categoryService, PCIEVersionService pcieVersionService, SocketService socketService, CPUGenerationService cpuGenerationService, BrandService brandService) {
        this.cpuRepository = cpuRepository;
        this.categoryService = categoryService;
        this.pcieVersionService = pcieVersionService;
        this.socketService = socketService;
        this.cpuGenerationService = cpuGenerationService;
        this.brandService = brandService;
    }

    public ProductResponse<CPU> getAllCPUs(int pageNumber, String searchText) {
        Page<CPU> page = Objects.equals(searchText, "") ? findAllCPUs(pageNumber) : findCPUsBySearch(pageNumber, searchText);
        return new ProductResponse<>(page.getNumber(), page.getTotalPages(), page.getContent());
    }

    public List<CPU> findCPUsForBuilder(Double price, Integer brand, Integer generation) throws BuildProductNotFoundException {
        List<CPU> cpuList = cpuRepository.findCPUSByPriceLessThanEqualAndBrandIdEqualsAndGenerationIdEquals(price, brand, generation, Sort.by(Sort.Direction.DESC, "price"));
        if (cpuList.size() == 0) {
            cpuList = cpuRepository.findCPUSByPriceGreaterThanAndBrandIdEqualsAndGenerationIdEquals(price, brand, generation, Sort.by(Sort.Direction.ASC, "price"));
        }
        if (cpuList.size() == 0) {
            throw new BuildProductNotFoundException();
        }
        return cpuList;
    }

    public CPU save(String name, Integer brand, String model, Double price, String imageUrl, Integer category,
                    Integer warrantyYears, String architecture, Integer PCIEVersion, Integer socket,
                    Integer coreCount, Integer highPerformanceCoreCount, Double baseClock, Double maxClock, Integer powerDraw,
                    Integer cpuGeneration) {
        CPU cpu = new CPU(name, brandService.getBrandById(brand), model, price, imageUrl, categoryService.getCategoryById(category), warrantyYears, architecture,
                pcieVersionService.getPCIEVersionById(PCIEVersion), socketService.getSocketById(socket), coreCount, highPerformanceCoreCount,
                baseClock, maxClock, powerDraw, cpuGenerationService.getCPUGenerationById(cpuGeneration));
        return cpuRepository.save(cpu);
    }

    private Page<CPU> findAllCPUs(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 10, Sort.by("price"));
        return cpuRepository.findAll(pageable);
    }

    private Page<CPU> findCPUsBySearch(int pageNumber, String searchText) {
        Pageable pageable = PageRequest.of(pageNumber, 10, Sort.by("price"));
        return cpuRepository
                .findCPUsByNameIgnoreCaseContainingOrBrandNameIgnoreCaseContainingOrModelIgnoreCaseContaining(searchText, searchText, searchText, pageable);
    }
}
