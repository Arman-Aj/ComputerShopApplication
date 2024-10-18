package com.armanaj.computershop.service.products.productBaseInfo;

import com.armanaj.computershop.model.products.productBaseInfo.Brand;
import com.armanaj.computershop.repository.products.productBaseInfo.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    private BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<Brand> getAllBrands() {
        return brandRepository.findAll().stream().toList();
    }

    public Brand getBrandById(Integer id) {
        return brandRepository.findById(id).orElseThrow();
    }

    public Brand save(String name) {
        Brand brand = new Brand(name);
        return brandRepository.save(brand);
    }
}
