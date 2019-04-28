package com.netcracker.edu.back.backend.service.implementation;

import com.netcracker.edu.back.backend.entity.Product;
import com.netcracker.edu.back.backend.entity.User;
import com.netcracker.edu.back.backend.repository.ProductRepository;
import com.netcracker.edu.back.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public Product getProductByName(String name) {
        return productRepository.getByName(name);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getProductsByUser(User user) {
        return productRepository.findAllByUser(user);
    }

    @Override
    public Page<Product> getAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
}
