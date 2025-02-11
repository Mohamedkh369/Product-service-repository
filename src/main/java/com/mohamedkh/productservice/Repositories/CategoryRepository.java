package com.mohamedkh.productservice.Repositories;

import com.mohamedkh.productservice.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
