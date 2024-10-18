package com.armanaj.computershop.repository.products;

import com.armanaj.computershop.model.products.StorageDrive;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StorageDriveRepository extends PagingAndSortingRepository<StorageDrive, Integer> {

    Page<StorageDrive> findStorageDrivesByNameIgnoreCaseContainingOrBrandNameIgnoreCaseContainingOrModelIgnoreCaseContaining
            (String name, String brand, String Model, Pageable pageable);

    List<StorageDrive> findStorageDrivesByPriceLessThanEqualAndCapacityGreaterThanEqualAndStorageDriveTypeIdEquals
            (Double price, Integer capacity, Integer storageDriveType, Sort sort);

    List<StorageDrive> findStorageDrivesByPriceGreaterThanAndCapacityGreaterThanEqualAndStorageDriveTypeIdEquals
            (Double price, Integer capacity, Integer storageDriveType, Sort sort);
}
