package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.dto.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts(int page);
    List<Product> getTopFourProducts();
    Product getProductById(Long id);
    Product getProductByName(String name);
    Product saveProduct(Product product);
}
