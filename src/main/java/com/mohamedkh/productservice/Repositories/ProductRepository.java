package com.mohamedkh.productservice.Repositories;

import com.mohamedkh.productservice.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
