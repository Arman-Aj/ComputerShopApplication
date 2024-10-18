package com.armanaj.computershop.repository.products;

import com.armanaj.computershop.model.products.Case;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaseRepository extends PagingAndSortingRepository<Case, Integer> {

    Page<Case> findCasesByNameIgnoreCaseContainingOrBrandNameIgnoreCaseContainingOrModelIgnoreCaseContaining
            (String name, String brand, String Model, Pageable pageable);

    List<Case> findCasesByPriceLessThanEqualAndFormFactorIdEquals
            (Double price, Integer formFactor, Sort sort);

    List<Case> findCasesByPriceGreaterThanAndFormFactorIdEquals
            (Double price, Integer formFactor, Sort sort);
}
