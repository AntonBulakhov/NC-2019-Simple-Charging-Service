package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.dto.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    List<Product> getTopFourProducts();
    Product getProductById(Long id);
    Product findProductByName(String name);
}
