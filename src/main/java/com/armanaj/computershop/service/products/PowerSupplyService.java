package com.armanaj.computershop.service.products;

import com.armanaj.computershop.exception.BuildProductNotFoundException;
import com.armanaj.computershop.model.products.PowerSupply;
import com.armanaj.computershop.payload.response.ProductResponse;
import com.armanaj.computershop.repository.products.PowerSupplyRepository;
import com.armanaj.computershop.service.products.productBaseInfo.BrandService;
import com.armanaj.computershop.service.products.productBaseInfo.CategoryService;
import com.armanaj.computershop.service.products.productBaseInfo.PowerRatingService;
import com.armanaj.computershop.service.products.productBaseInfo.PowerSupplyFormFactorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PowerSupplyService {

    private final PowerSupplyRepository powerSupplyRepository;

    private final BrandService brandService;

    private final CategoryService categoryService;

    private final PowerRatingService powerRatingService;

    private final PowerSupplyFormFactorService powerSupplyFormFactorService;

    public PowerSupplyService(PowerSupplyRepository powerSupplyRepository, BrandService brandService, CategoryService categoryService, PowerRatingService powerRatingService, PowerSupplyFormFactorService powerSupplyFormFactorService) {
        this.powerSupplyRepository = powerSupplyRepository;
        this.brandService = brandService;
        this.categoryService = categoryService;
        this.powerRatingService = powerRatingService;
        this.powerSupplyFormFactorService = powerSupplyFormFactorService;
    }

    public ProductResponse<PowerSupply> getAllPowerSupplies(int pageNumber, String searchText) {
        Page<PowerSupply> page = Objects.equals(searchText, "") ? findAllPowerSupplies(pageNumber) : findPowerSuppliesBySearch(pageNumber, searchText);
        return new ProductResponse<>(page.getNumber(), page.getTotalPages(), page.getContent());
    }

    public List<PowerSupply> findPowerSuppliesForBuilder(Double price, Integer formFactor, Integer powerRating, Integer powerRequirement) throws BuildProductNotFoundException {
        List<PowerSupply> powerSupplyList = powerSupplyRepository.findPowerSuppliesByPriceLessThanEqualAndPowerSupplyFormFactorIdEqualsAndPowerRatingIdGreaterThanEqualAndWattageGreaterThanEqual(price, formFactor, powerRating, powerRequirement, Sort.by(Sort.Direction.DESC, "price"));
        if (powerSupplyList.size() == 0) {
            powerSupplyList = powerSupplyRepository.findPowerSuppliesByPriceGreaterThanAndPowerSupplyFormFactorIdEqualsAndPowerRatingIdGreaterThanEqualAndWattageGreaterThanEqual(price, formFactor, powerRating, powerRequirement, Sort.by(Sort.Direction.ASC, "price"));
        }
        if (powerSupplyList.size() == 0) {
            throw new BuildProductNotFoundException();
        }
        return powerSupplyList;
    }

    public PowerSupply save(String name, Integer brand, String model, Double price, String imageUrl, Integer category, Integer warrantyYears,
                            Integer wattage, Integer powerRating, Integer powerSupplyFormFactor) {
        PowerSupply powerSupply = new PowerSupply(name, brandService.getBrandById(brand), model, price, imageUrl, categoryService.getCategoryById(category),
                warrantyYears, wattage, powerRatingService.getPowerRatingById(powerRating), powerSupplyFormFactorService.getPowerSupplyFormFactorById(powerSupplyFormFactor));
        return powerSupplyRepository.save(powerSupply);
    }

    private Page<PowerSupply> findAllPowerSupplies(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 10, Sort.by("price"));
        return powerSupplyRepository.findAll(pageable);
    }

    private Page<PowerSupply> findPowerSuppliesBySearch(int pageNumber, String searchText) {
        Pageable pageable = PageRequest.of(pageNumber, 10, Sort.by("price"));
        return powerSupplyRepository
                .findPowerSuppliesByNameIgnoreCaseContainingOrBrandNameIgnoreCaseContainingOrModelIgnoreCaseContaining(searchText, searchText, searchText, pageable);
    }
}
