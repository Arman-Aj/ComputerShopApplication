package com.armanaj.computershop.service.products.productBaseInfo;

import com.armanaj.computershop.model.products.productBaseInfo.Category;
import com.armanaj.computershop.repository.products.productBaseInfo.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll().stream().toList();
    }

    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(id).orElseThrow();
    }

    public Category save(String name) {
        Category category = new Category(name);
        return categoryRepository.save(category);
    }
}
