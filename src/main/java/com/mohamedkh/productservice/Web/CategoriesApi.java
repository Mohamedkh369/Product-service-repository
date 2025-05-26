package com.mohamedkh.productservice.Web;
import com.mohamedkh.productservice.DTOs.CategoryDTO;
import com.mohamedkh.productservice.Entities.Category;
import com.mohamedkh.productservice.Mappers.CategoryMapper;
import com.mohamedkh.productservice.Services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/categories")
public class CategoriesApi {

    private CategoryService categoryService;
    private CategoryMapper categoryMapper;

    public CategoriesApi(CategoryService categoryService, CategoryMapper categoryMapper) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }


    @PostMapping("/createCategory")
    public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO) {
        Category newCategory = this.categoryMapper.categoryDTOToCategory(categoryDTO);
        this.categoryService.createCategory(newCategory);
        return this.categoryMapper.categoryToCategoryDTO(newCategory);
    }

    @GetMapping("/getAllCategories")
    public List<CategoryDTO> getAllCategories() {
        return this.categoryService.findAll().stream()
                .map(categoryMapper::categoryToCategoryDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/getCategoryById/{id}")
    public CategoryDTO getCategoryById(@PathVariable long id) {
        return this.categoryMapper.categoryToCategoryDTO(this.categoryService.findById(id));
    }

    @PutMapping("/updateCategory/{id}")
    public CategoryDTO updateCategory(@PathVariable long id , @RequestBody CategoryDTO categoryDTO) {
        return this.categoryMapper.categoryToCategoryDTO(this.categoryService.updateCategory(id,categoryDTO));
    }

    @DeleteMapping("/deleteCategory/{id}")
    public void deleteCategory(@PathVariable long id) {
        this.categoryService.deleteCategory(id);
    }

}
