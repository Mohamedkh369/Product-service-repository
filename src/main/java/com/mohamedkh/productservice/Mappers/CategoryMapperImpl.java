package com.mohamedkh.productservice.Mappers;

import com.mohamedkh.productservice.DTOs.CategoryDTO;
import com.mohamedkh.productservice.Entities.Category;
import org.springframework.stereotype.Component;


@Component
public class CategoryMapperImpl implements CategoryMapper {
    @Override
    public CategoryDTO categoryToCategoryDTO(Category category){
        if (category == null) {
            return null;
        }
        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public Category categoryDTOToCategory(CategoryDTO categoryDTO){
        if (categoryDTO == null) {
            return null;
        }
        return Category.builder()
                .id(categoryDTO.getId())
                .name(categoryDTO.getName())
                .build();

    }


}
