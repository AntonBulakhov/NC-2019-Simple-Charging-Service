package com.netcracker.edu.back.backend.controller;

import com.netcracker.edu.back.backend.entity.Product;
import com.netcracker.edu.back.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/get_all", method = RequestMethod.GET)
    public List<Product> getAllProducts(){
        return productService.findAll();
    }
}
