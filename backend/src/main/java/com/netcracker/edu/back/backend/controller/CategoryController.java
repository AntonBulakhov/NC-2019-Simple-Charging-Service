package com.netcracker.edu.back.backend.controller;

import com.netcracker.edu.back.backend.entity.Category;
import com.netcracker.edu.back.backend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public Set<Category> getAllCategories(){
        return (Set<Category>)categoryRepository.findAll();
    }
}
