package com.armanaj.computershop.repository.products;

import com.armanaj.computershop.model.products.CPU;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CPURepository extends PagingAndSortingRepository<CPU, Integer> {

    Page<CPU> findCPUsByNameIgnoreCaseContainingOrBrandNameIgnoreCaseContainingOrModelIgnoreCaseContaining
            (String name, String brand, String Model, Pageable pageable);

    List<CPU> findCPUSByPriceLessThanEqualAndBrandIdEqualsAndGenerationIdEquals
            (Double price, Integer brand, Integer cpuGeneration, Sort sort);

    List<CPU> findCPUSByPriceGreaterThanAndBrandIdEqualsAndGenerationIdEquals
            (Double price, Integer brand, Integer cpuGeneration, Sort sort);
}
