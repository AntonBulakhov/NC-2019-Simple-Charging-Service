package com.netcracker.edu.back.backend.service;

import com.netcracker.edu.back.backend.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();
    Optional<Product> getProductById(Integer id);
}
