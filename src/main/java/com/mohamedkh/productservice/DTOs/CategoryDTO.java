package com.mohamedkh.productservice.DTOs;
import com.mohamedkh.productservice.Entities.Product;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Builder
@Data
public class CategoryDTO {
    private long id;
    private String name;
    private String description;
    private Set<Product> products;

}
