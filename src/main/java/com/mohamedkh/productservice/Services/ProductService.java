package com.mohamedkh.productservice.Services;


import com.mohamedkh.productservice.DTOs.CategoryDTO;
import com.mohamedkh.productservice.DTOs.ProductDTO;
import com.mohamedkh.productservice.Entities.Category;
import com.mohamedkh.productservice.Entities.Product;
import com.mohamedkh.productservice.Exceptions.CategoryNotFoundException;
import com.mohamedkh.productservice.Exceptions.ProductNotFoundException;
import com.mohamedkh.productservice.Repositories.CategoryRepository;
import com.mohamedkh.productservice.Repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository , CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);

    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + id + " not found"));
    }

    public Product updateProduct( long id, ProductDTO product) {
        if (this.productRepository.existsById(id))
        {
        Product oldProduct = getProductById(id);
        oldProduct.setName(product.getName());
        oldProduct.setPrice(product.getPrice());
        oldProduct.setImage(product.getImage());
        oldProduct.setSellerId(product.getSellerId());
        Set<Category> newCategories = product.getCategories().stream()
                .map(categoryDTO -> categoryRepository.findById(categoryDTO.getId())
                .orElseThrow(() -> new CategoryNotFoundException("Category with id " + categoryDTO.getId() + " not found")))
                .collect(Collectors.toSet());
        oldProduct.setCategories(newCategories);
        return productRepository.save(oldProduct);
        }
        else {
            throw new ProductNotFoundException("Product with id " + id + " not found");
        }
    }

    public void deleteProduct(long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        } else {
            throw new ProductNotFoundException("Product with id " + id + " not found");
        }

        }



}
