package com.netcracker.edu.back.backend.controller;

import com.netcracker.edu.back.backend.entity.Category;
import com.netcracker.edu.back.backend.repository.CategoryRepository;
import com.netcracker.edu.back.backend.service.CategoryService;
import com.netcracker.edu.back.backend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public List<Category> getAllCategories(){
        return categoryService.findAll();
    }
}
