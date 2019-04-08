package com.netcracker.edu.back.backend.repository;

import com.netcracker.edu.back.backend.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
