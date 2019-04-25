package com.netcracker.edu.back.backend.controller;

import com.netcracker.edu.back.backend.entity.Product;
import com.netcracker.edu.back.backend.entity.Subscription;
import com.netcracker.edu.back.backend.service.ProductService;
import com.netcracker.edu.back.backend.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:8081", allowedHeaders = "*")
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private SubscriptionService subscriptionService;

    private final int PRODUCT_COUNT_ON_PAGE = 4;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Page<Product> getAllProducts(@RequestParam(defaultValue = "0") int page){
        return productService.getAll(new PageRequest(page, PRODUCT_COUNT_ON_PAGE));
    }

    @RequestMapping(value = "/top4", method = RequestMethod.GET)
    public List<Product> getTopFourProducts(){
        List<Product> products = new ArrayList<>();
        ArrayList<Subscription> subscriptions = (ArrayList<Subscription>)subscriptionService.getTopFourSubs();
        if(subscriptions.size() == 0){
            products = productService.getAll();
            if(products.size() >= 4) products = products.subList(0,4);
        }else {
            if(subscriptions.size() < 4){
                for (Subscription sub: subscriptions) {
                    products.add(sub.getProduct());
                }
            }else {
                for (int i = 0; i < 4; i++) {
                    products.add(subscriptions.get(i).getProduct());
                }
            }
        }
        return products;
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public Optional<Product> getAllProducts(@PathVariable(name = "id") Integer id){
        return productService.getProductById(id);
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public ResponseEntity<Product> getProductByName(@PathVariable String name){
        Product product = productService.getProductByName(name);
        return ResponseEntity.ok(product);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        productService.saveProduct(product);
        return ResponseEntity.ok(productService.getProductByName(product.getName()));
    }
}
