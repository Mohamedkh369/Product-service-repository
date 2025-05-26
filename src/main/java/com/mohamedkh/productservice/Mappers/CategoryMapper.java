package com.mohamedkh.productservice.Mappers;

import com.mohamedkh.productservice.DTOs.CategoryDTO;
import com.mohamedkh.productservice.Entities.Category;

public interface CategoryMapper {
    public CategoryDTO categoryToCategoryDTO(Category category);
    public Category categoryDTOToCategory(CategoryDTO categoryDTO);
}
