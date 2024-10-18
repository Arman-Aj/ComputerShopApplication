package com.armanaj.computershop.repository.products;

import com.armanaj.computershop.model.products.PowerSupply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PowerSupplyRepository extends PagingAndSortingRepository<PowerSupply, Integer> {

    Page<PowerSupply> findPowerSuppliesByNameIgnoreCaseContainingOrBrandNameIgnoreCaseContainingOrModelIgnoreCaseContaining
            (String name, String brand, String Model, Pageable pageable);

    List<PowerSupply> findPowerSuppliesByPriceLessThanEqualAndPowerSupplyFormFactorIdEqualsAndPowerRatingIdGreaterThanEqualAndWattageGreaterThanEqual
            (Double price, Integer powerSupplyFormFactor, Integer powerRating, Integer wattage, Sort sort);

    List<PowerSupply> findPowerSuppliesByPriceGreaterThanAndPowerSupplyFormFactorIdEqualsAndPowerRatingIdGreaterThanEqualAndWattageGreaterThanEqual
            (Double price, Integer powerSupplyFormFactor, Integer powerRating, Integer wattage, Sort sort);
}
