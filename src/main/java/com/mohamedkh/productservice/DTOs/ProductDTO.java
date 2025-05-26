package com.mohamedkh.productservice.DTOs;

import com.mohamedkh.productservice.Entities.Category;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Builder
@Data
public class ProductDTO {
    private Long id;
    private String name;
    private Set<CategoryDTO> categories;
    private String sellerId;
    private Double price;
    private String image;

}
