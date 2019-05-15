package com.netcracker.edu.back.backend.service;

import com.netcracker.edu.back.backend.entity.Category;
import com.netcracker.edu.back.backend.entity.Product;
import com.netcracker.edu.back.backend.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAll();
    Optional<Product> getProductById(Integer id);
    Product getProductByName(String name);
    Product saveProduct(Product product);
    Page<Product> getAll(Pageable pageable);
    List<Product> getProductsByUser(User user);
    Page<Product> findAllByCategory(Category category, Pageable pageable);
    void delete(Product product);
}
