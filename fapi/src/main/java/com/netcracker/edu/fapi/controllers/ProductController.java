package com.netcracker.edu.fapi.controllers;

import com.netcracker.edu.fapi.dto.Product;
import com.netcracker.edu.fapi.service.ProductService;
import com.netcracker.edu.fapi.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private StorageService storageService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Page<Product>> getAllProducts(@RequestParam int page){
       Page<Product> list = productService.getAllProducts(page);
       if (list.getContent() != null) {
           return ResponseEntity.ok(list);
       }else {
           return ResponseEntity.notFound().build();
       }
    }

    @RequestMapping(value = "/top4", method = RequestMethod.GET)
    public List<Product> getTopFourProducts(){
        return productService.getTopFourProducts();
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> getProductById(@PathVariable(name = "id") Long id){
        Product product = productService.getProductById(id);
        if(product != null){
            return ResponseEntity.ok(product);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public ResponseEntity<Product> getProductByName(@PathVariable String name){
        Product product = productService.getProductByName(name);
        if(product != null){
            return ResponseEntity.ok(product);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/user/id/{id}")
    public ResponseEntity<List<Product>> getProductsByUser(@PathVariable int id){
        return ResponseEntity.ok(productService.getProductsByUser(id));
    }

    @PostMapping("/name")
    public ResponseEntity<Boolean> findProductByName(@RequestBody String name){
        Product product = productService.getProductByName(name);
        if (product == null) {
            return ResponseEntity.ok(false);
        }else {
            return ResponseEntity.ok(true);
        }
    }

    @PreAuthorize("hasRole('SELLER')")
    @PostMapping("")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        Product product1 = productService.saveProduct(product);
        if(product1 != null){
            return ResponseEntity.ok(product1);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/image")
    public ResponseEntity saveProductImage(@RequestParam("image") MultipartFile file){
        if(storageService.storeProductImage(file)){
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/image/{name}")
    public ResponseEntity<Resource> getProductImage(@PathVariable String name){
        Resource res = storageService.getProductImage(name);
        if(res != null){
            return ResponseEntity.ok(res);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
