package com.mohamedkh.productservice.Services;


import com.mohamedkh.productservice.Entities.Product;
import com.mohamedkh.productservice.Repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}
