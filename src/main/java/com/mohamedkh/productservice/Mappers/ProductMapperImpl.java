package com.mohamedkh.productservice.Mappers;

import com.mohamedkh.productservice.DTOs.CategoryDTO;
import com.mohamedkh.productservice.DTOs.ProductDTO;
import com.mohamedkh.productservice.Entities.Category;
import com.mohamedkh.productservice.Entities.Product;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDTO productToProductDTO(Product product){
        if (product == null){
            return null;
        }
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .image(product.getImage())
                .sellerId(product.getSellerId())
                .categories(
                        product.getCategories().stream()
                                .map(category -> CategoryDTO.builder()
                                        .id(category.getId())
                                        .name(category.getName())
                                        .build()
                                )
                                .collect(Collectors.toSet())
                )
                .build();
    }

    @Override
    public Product productDTOToProduct(ProductDTO productDTO){
        if (productDTO == null){
            return null;
        }

        return Product.builder()
                .id(productDTO.getId())
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .image(productDTO.getImage())
                .sellerId(productDTO.getSellerId())
                .categories( productDTO.getCategories().stream()
                        .map(categoryDTO -> Category.builder()
                                .id(categoryDTO.getId())
                                .name(categoryDTO.getName())
                                .build()
                        )
                        .collect(Collectors.toSet())
                )
                .build();
    }
}
