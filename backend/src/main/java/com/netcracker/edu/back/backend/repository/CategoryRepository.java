package com.netcracker.edu.back.backend.repository;

import com.netcracker.edu.back.backend.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Category getCategoryByName(String name);
}
