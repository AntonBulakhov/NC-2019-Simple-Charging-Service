package com.netcracker.edu.fapi.service.implementation;

import com.netcracker.edu.fapi.dto.Product;
import com.netcracker.edu.fapi.service.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ProductServiceImpl  implements ProductService {
    @Value("${backend.server.url}")
    private String backendURL;

    @Override
    public List<Product> getAllProducts() {
        RestTemplate restTemplate = new RestTemplate();
        Product[] products  = restTemplate.getForObject(backendURL + "/api/products", Product[].class);
        return products == null ? Collections.emptyList() : Arrays.asList(products);
    }

    @Override
    public List<Product> getTopFourProducts() {
        RestTemplate restTemplate = new RestTemplate();
        Product[] products = restTemplate.getForObject(backendURL + "/api/products/top4", Product[].class);
        return products == null ? Collections.emptyList() : Arrays.asList(products);
    }

    @Override
    public Product getProductById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendURL + "/api/products/" + id, Product.class);
    }
}