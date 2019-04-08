package com.netcracker.edu.back.backend.service;

import com.netcracker.edu.back.backend.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAll();
    Optional<Category> findById(Long id);
    Category getCategoryByName(String name);
    Category save(Category category);
}
