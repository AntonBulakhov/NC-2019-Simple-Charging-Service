package com.netcracker.edu.fapi.service.implementation;

import com.netcracker.edu.fapi.dto.Product;
import com.netcracker.edu.fapi.service.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
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
    public void deleteProduct(int id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendURL + "/api/products/id/"+id);
    }

    @Override
    public Product getProductByName(String name) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendURL + "/api/products/name/" + name, Product.class);
    }

    @Override
    public Page<Product> getAllProducts(int page, String order, String filter) {
        RestTemplate restTemplate = new RestTemplate();
        return  restTemplate.getForObject(backendURL + "/api/products?page=" + page +
                "&order="+order+"&filter="+filter, RestPageImpl.class);
    }

    @Override
    public List<Product> getTopFourProducts() {
        RestTemplate restTemplate = new RestTemplate();
        Product[] products = restTemplate.getForObject(backendURL + "/api/products/top4", Product[].class);
        return products == null ? Collections.emptyList() : Arrays.asList(products);
    }

    @Override
    public List<Product> getProductsByUser(int id) {
        RestTemplate restTemplate = new RestTemplate();
        Product[] products = restTemplate.getForObject(backendURL + "/api/products/user/id/"+id, Product[].class);
        return products == null ? Collections.emptyList() : Arrays.asList(products);
    }

    @Override
    public Product getProductById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendURL + "/api/products/id/" + id, Product.class);
    }

    @Override
    public Product saveProduct(Product product) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendURL + "/api/products", product, Product.class).getBody();
    }
}
