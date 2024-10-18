package com.armanaj.computershop.repository.products;

import com.armanaj.computershop.model.products.Motherboard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotherboardRepository extends PagingAndSortingRepository<Motherboard, Integer> {

    Page<Motherboard> findMotherboardsByNameIgnoreCaseContainingOrBrandNameIgnoreCaseContainingOrModelIgnoreCaseContaining
            (String name, String brand, String Model, Pageable pageable);

    List<Motherboard> findMotherboardsByPriceLessThanEqualAndSocketIdEqualsAndFormFactorIdLessThanEqual
            (Double price, Integer socket, Integer formFactor, Sort sort);

    List<Motherboard> findMotherboardsByPriceGreaterThanAndSocketIdEqualsAndFormFactorIdLessThanEqual
            (Double price, Integer socket, Integer formFactor, Sort sort);
}
