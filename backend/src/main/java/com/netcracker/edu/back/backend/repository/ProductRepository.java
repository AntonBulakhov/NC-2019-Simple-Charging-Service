package com.netcracker.edu.back.backend.repository;

import com.netcracker.edu.back.backend.entity.Category;
import com.netcracker.edu.back.backend.entity.Product;
import com.netcracker.edu.back.backend.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
    Product getByName(String name);
    Page<Product> findAll(Pageable pageable);
    List<Product> findAll();
    List<Product> findAllByUser(User user);
    Page<Product> findAllByCategory(Category category, Pageable pageable);
}
