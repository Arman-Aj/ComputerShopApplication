package com.armanaj.computershop.service.products;

import com.armanaj.computershop.model.products.Product;
import com.armanaj.computershop.payload.response.ProductResponse;
import com.armanaj.computershop.repository.products.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponse<Product> getAllProducts(int pageNumber, String searchText) {
        Page<Product> page = Objects.equals(searchText, "") ? findAllProducts(pageNumber) : findProductsBySearch(pageNumber, searchText);
        return new ProductResponse<>(page.getNumber(), page.getTotalPages(), page.getContent());
    }

    private Page<Product> findAllProducts(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 10, Sort.by("price"));
        return productRepository.findAll(pageable);
    }

    private Page<Product> findProductsBySearch(int pageNumber, String searchText) {
        Pageable pageable = PageRequest.of(pageNumber, 10, Sort.by("price"));
        return productRepository
                .findProductsByNameIgnoreCaseContainingOrBrandNameIgnoreCaseContainingOrModelIgnoreCaseContaining(searchText, searchText, searchText, pageable);
    }
}
