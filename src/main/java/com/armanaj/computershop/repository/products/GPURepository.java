package com.armanaj.computershop.repository.products;

import com.armanaj.computershop.model.products.GPU;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GPURepository extends PagingAndSortingRepository<GPU, Integer> {

    Page<GPU> findGPUsByNameIgnoreCaseContainingOrBrandNameIgnoreCaseContainingOrModelIgnoreCaseContaining
            (String name, String brand, String Model, Pageable pageable);

    List<GPU> findGPUSByPriceLessThanEqualAndChipsetBrandIdEqualsAndGenerationIdEquals
            (Double price, Integer chipsetBrand, Integer gpuGeneration, Sort sort);

    List<GPU> findGPUSByPriceGreaterThanAndChipsetBrandIdEqualsAndGenerationIdEquals
            (Double price, Integer chipsetBrand, Integer gpuGeneration, Sort sort);
}
