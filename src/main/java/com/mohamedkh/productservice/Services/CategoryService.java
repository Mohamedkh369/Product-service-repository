package com.mohamedkh.productservice.Services;


import com.mohamedkh.productservice.DTOs.CategoryDTO;
import com.mohamedkh.productservice.Entities.Category;
import com.mohamedkh.productservice.Exceptions.CategoryNotFoundException;
import com.mohamedkh.productservice.Repositories.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category with id "+id+ " not found"));
    }


    public Category updateCategory(long id , CategoryDTO category) {
        if (categoryRepository.findById(id).isPresent()) {
        Category oldCategory = this.findById(id);
        oldCategory.setName(category.getName());
        return this.categoryRepository.save(oldCategory);
    }
        else throw new CategoryNotFoundException("Category with id "+id+ " not found");
    }

    public void deleteCategory(long id) {
        if (categoryRepository.findById(id).isPresent()) {

            this.categoryRepository.deleteById(id);
        }
        else {
            throw new CategoryNotFoundException("Category with id "+id+ " not found");
        }

    }


}
