package com.mohamedkh.productservice.Mappers;

import com.mohamedkh.productservice.DTOs.ProductDTO;
import com.mohamedkh.productservice.Entities.Product;

public interface ProductMapper {
        ProductDTO productToProductDTO(Product product);
        Product productDTOToProduct(ProductDTO productDTO);
}
