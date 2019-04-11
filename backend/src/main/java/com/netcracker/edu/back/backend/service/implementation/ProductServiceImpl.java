package com.netcracker.edu.back.backend.service.implementation;

import com.netcracker.edu.back.backend.entity.Product;
import com.netcracker.edu.back.backend.repository.ProductRepository;
import com.netcracker.edu.back.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }
}
