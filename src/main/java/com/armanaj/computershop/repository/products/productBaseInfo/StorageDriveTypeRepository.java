package com.armanaj.computershop.repository.products.productBaseInfo;

import com.armanaj.computershop.model.products.productBaseInfo.StorageDriveType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageDriveTypeRepository extends JpaRepository<StorageDriveType, Integer> {
}
