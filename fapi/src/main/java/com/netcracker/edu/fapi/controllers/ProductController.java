package com.netcracker.edu.fapi.controllers;

import com.netcracker.edu.fapi.dto.Product;
import com.netcracker.edu.fapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @RequestMapping(value = "/top4", method = RequestMethod.GET)
    public List<Product> getTopFourProducts(){
        return productService.getTopFourProducts();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> getProductById(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping("/name")
    public ResponseEntity<Boolean> findProductByName(@RequestBody String name){
        Product product = productService.findProductByName(name);
        if (product == null) {
            return ResponseEntity.ok(false);
        }else {
            return ResponseEntity.ok(true);
        }
    }
}
