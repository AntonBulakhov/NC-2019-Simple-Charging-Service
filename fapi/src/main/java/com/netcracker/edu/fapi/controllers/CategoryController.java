package com.netcracker.edu.fapi.controllers;

import com.netcracker.edu.fapi.dto.Category;
import com.netcracker.edu.fapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public List<Category> getCategories(){
        return categoryService.getCategories();
    }
}
