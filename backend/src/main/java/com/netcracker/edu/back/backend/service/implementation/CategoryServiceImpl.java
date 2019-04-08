package com.netcracker.edu.back.backend.service.implementation;

import com.netcracker.edu.back.backend.entity.Category;
import com.netcracker.edu.back.backend.repository.CategoryRepository;
import com.netcracker.edu.back.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return (List<Category>)categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category getCategoryByName(String name) {
        return categoryRepository.getCategoryByName(name);
    }

    @Override
    public Category save(Category category) {
        return null;
    }
}
