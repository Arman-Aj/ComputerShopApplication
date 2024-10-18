package com.armanaj.computershop.repository.products.productBaseInfo;

import com.armanaj.computershop.model.products.productBaseInfo.GPUGeneration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GPUGenerationRepository extends JpaRepository<GPUGeneration, Integer> {
}
