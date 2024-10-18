package com.armanaj.computershop.service.products;

import com.armanaj.computershop.exception.BuildProductNotFoundException;
import com.armanaj.computershop.model.products.Case;
import com.armanaj.computershop.payload.response.ProductResponse;
import com.armanaj.computershop.repository.products.CaseRepository;
import com.armanaj.computershop.service.products.productBaseInfo.BrandService;
import com.armanaj.computershop.service.products.productBaseInfo.CategoryService;
import com.armanaj.computershop.service.products.productBaseInfo.MotherboardFormFactorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CaseService {

    private final CaseRepository caseRepository;
    private final BrandService brandService;
    private final CategoryService categoryService;
    private final MotherboardFormFactorService motherboardFormFactorService;

    public CaseService(CaseRepository caseRepository, BrandService brandService, CategoryService categoryService, MotherboardFormFactorService motherboardFormFactorService) {
        this.caseRepository = caseRepository;
        this.brandService = brandService;
        this.categoryService = categoryService;
        this.motherboardFormFactorService = motherboardFormFactorService;
    }

    public ProductResponse<Case> getAllCases(int pageNumber, String searchText) {
        Page<Case> page = Objects.equals(searchText, "") ? findAllCases(pageNumber) : findCasesBySearch(pageNumber, searchText);
        return new ProductResponse<>(page.getNumber(), page.getTotalPages(), page.getContent());
    }

    public List<Case> findCasesForBuilder(Double price, Integer formFactor) throws BuildProductNotFoundException {
        List<Case> caseList = caseRepository.findCasesByPriceLessThanEqualAndFormFactorIdEquals(price, formFactor, Sort.by(Sort.Direction.DESC, "price"));
        if (caseList.size() == 0) {
            caseList = caseRepository.findCasesByPriceGreaterThanAndFormFactorIdEquals(price, formFactor, Sort.by(Sort.Direction.ASC, "price"));
        }
        if (caseList.size() == 0) {
            throw new BuildProductNotFoundException();
        }
        return caseList;
    }

    public Case save(String name, Integer brand, String model, Double price, String imageUrl,
                     Integer category, Integer warrantyYears, Integer formFactor, Integer fanCount) {
        Case _case = new Case(name, brandService.getBrandById(brand), model, price, imageUrl,
                categoryService.getCategoryById(category), warrantyYears,
                motherboardFormFactorService.getMotherboardFormFactorById(formFactor), fanCount);
        return caseRepository.save(_case);
    }

    private Page<Case> findAllCases(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 10, Sort.by("price"));
        return caseRepository.findAll(pageable);
    }

    private Page<Case> findCasesBySearch(int pageNumber, String searchText) {
        Pageable pageable = PageRequest.of(pageNumber, 10, Sort.by("price"));
        return caseRepository
                .findCasesByNameIgnoreCaseContainingOrBrandNameIgnoreCaseContainingOrModelIgnoreCaseContaining(searchText, searchText, searchText, pageable);
    }
}
