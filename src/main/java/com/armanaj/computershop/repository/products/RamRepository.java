package com.armanaj.computershop.repository.products;

import com.armanaj.computershop.model.products.Ram;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RamRepository extends PagingAndSortingRepository<Ram, Integer> {

    Page<Ram> findRamsByNameIgnoreCaseContainingOrBrandNameIgnoreCaseContainingOrModelIgnoreCaseContaining
            (String name, String brand, String Model, Pageable pageable);

    List<Ram> findRamsByPriceLessThanEqualAndCapacityGreaterThanEqualAndPCIEVersionIdLessThanEqual
            (Double price, Integer capacity, Integer pcieVersion, Sort sort);

    List<Ram> findRamsByPriceGreaterThanAndCapacityGreaterThanEqualAndPCIEVersionIdLessThanEqual
            (Double price, Integer capacity, Integer pcieVersion, Sort sort);
}
