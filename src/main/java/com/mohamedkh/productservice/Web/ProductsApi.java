package com.mohamedkh.productservice.Web;

import com.mohamedkh.productservice.DTOs.ProductDTO;
import com.mohamedkh.productservice.Entities.Product;
import com.mohamedkh.productservice.Mappers.ProductMapper;
import com.mohamedkh.productservice.Services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
public class ProductsApi {

    private ProductService productService;
    private ProductMapper productMapper;

    public ProductsApi(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @PostMapping("/createProduct")
    public ProductDTO createProduct(@RequestBody ProductDTO product) {
        Product newProduct = this.productMapper.productDTOToProduct(product);
         this.productService.createProduct(newProduct);
         return this.productMapper.productToProductDTO(newProduct);
    }

    @GetMapping("/getAllProducts")
    public List<ProductDTO> getAllProducts() {
        return this.productService.getAllProducts().stream()
                .map(productMapper::productToProductDTO)
                .collect(Collectors.toList());
    }


    @GetMapping("/getProductById/{id}")
    public ProductDTO getProductById(@PathVariable long id) {
        return this.productMapper.productToProductDTO(this.productService.getProductById(id));
    }

    @PutMapping("updateProduct/{id}")
    public ProductDTO updateProductById(@PathVariable long id , @RequestBody ProductDTO productDTO) {
        return this.productMapper.productToProductDTO(this.productService.updateProduct(id,productDTO));
    }

    @DeleteMapping("deleteProduct/{id}")
    public void deleteProductById(@PathVariable long id) {
        this.productService.deleteProduct(id);
    }




}
