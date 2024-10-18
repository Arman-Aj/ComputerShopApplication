package com.armanaj.computershop.service.products;

import com.armanaj.computershop.exception.BuildProductNotFoundException;
import com.armanaj.computershop.model.products.Ram;
import com.armanaj.computershop.payload.response.ProductResponse;
import com.armanaj.computershop.repository.products.RamRepository;
import com.armanaj.computershop.service.products.productBaseInfo.BrandService;
import com.armanaj.computershop.service.products.productBaseInfo.CategoryService;
import com.armanaj.computershop.service.products.productBaseInfo.PCIEVersionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class RamService {

    private final RamRepository ramRepository;

    private final BrandService brandService;

    private final CategoryService categoryService;

    private final PCIEVersionService pcieVersionService;

    public RamService(RamRepository ramRepository, BrandService brandService, CategoryService categoryService, PCIEVersionService pcieVersionService) {
        this.ramRepository = ramRepository;
        this.brandService = brandService;
        this.categoryService = categoryService;
        this.pcieVersionService = pcieVersionService;
    }

    public ProductResponse<Ram> getAllRams(int pageNumber, String searchText) {
        Page<Ram> page = Objects.equals(searchText, "") ? findAllRams(pageNumber) : findRamsBySearch(pageNumber, searchText);
        return new ProductResponse<>(page.getNumber(), page.getTotalPages(), page.getContent());
    }

    public List<Ram> findRamsForBuilder (Double price, Integer capacity, Integer pcieVersion) throws BuildProductNotFoundException {
        List<Ram> ramList = ramRepository.findRamsByPriceLessThanEqualAndCapacityGreaterThanEqualAndPCIEVersionIdLessThanEqual(price, capacity, pcieVersion, Sort.by(Sort.Direction.DESC, "price"));
        if (ramList.size() == 0) {
            ramList = ramRepository.findRamsByPriceGreaterThanAndCapacityGreaterThanEqualAndPCIEVersionIdLessThanEqual(price, capacity, pcieVersion, Sort.by(Sort.Direction.ASC, "price"));
        }
        if (ramList.size() == 0) {
            throw new BuildProductNotFoundException();
        }
        return ramList;
    }

    public Ram save(String name, Integer brand, String model, Double price, String imageUrl, Integer category,
                    Integer warrantyYears, Integer pcieVersion, Integer clockSpeed, Integer capacity,
                    Integer stickCount, Integer latency) {
        Ram ram = new Ram(name, brandService.getBrandById(brand), model, price, imageUrl, categoryService.getCategoryById(category),
                warrantyYears, pcieVersionService.getPCIEVersionById(pcieVersion), clockSpeed, capacity,
                stickCount, latency);
        return ramRepository.save(ram);
    }

    private Page<Ram> findAllRams(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 10, Sort.by("price"));
        return ramRepository.findAll(pageable);
    }

    private Page<Ram> findRamsBySearch(int pageNumber, String searchText) {
        Pageable pageable = PageRequest.of(pageNumber, 10, Sort.by("price"));
        return ramRepository
                .findRamsByNameIgnoreCaseContainingOrBrandNameIgnoreCaseContainingOrModelIgnoreCaseContaining(searchText, searchText, searchText, pageable);
    }
}
