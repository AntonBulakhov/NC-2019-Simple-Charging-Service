package com.netcracker.edu.fapi.service.implementation;

import com.netcracker.edu.fapi.dto.Category;
import com.netcracker.edu.fapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Value("${backend.server.url}")
    private String backendURL;

    @Override
    public List<Category> getCategories() {
        RestTemplate restTemplate = new RestTemplate();
        Category[] categories  = restTemplate.getForObject(backendURL + "/api/categories", Category[].class);
        return categories == null ? Collections.emptyList() : Arrays.asList(categories);
    }
}
