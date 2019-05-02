package com.netcracker.edu.fapi.controllers;

import com.netcracker.edu.fapi.dto.Subscription;
import com.netcracker.edu.fapi.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {
    @Autowired
    private SubscriptionService subscriptionService;

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/user/{id}")
    public ResponseEntity<List<Subscription>> getSubsByUser(@PathVariable int id){
        List<Subscription> subscriptions = subscriptionService.getSubsByUser(id);
        if(!subscriptions.isEmpty()){
            return ResponseEntity.ok(subscriptions);
        }else {
            return ResponseEntity.ok(null);
        }
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping("")
    public ResponseEntity<Boolean> saveSubscription(@RequestBody Subscription sub){
        Subscription subscription = subscriptionService.save(sub);
        if(subscription != null){
            return ResponseEntity.ok(true);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/exist/{id}/{productId}")
    public ResponseEntity<Boolean> checkSubExist(@PathVariable int id, @PathVariable int productId){
        Subscription subscription = subscriptionService.checkSub(id, productId);
        if(subscription != null){
            return ResponseEntity.ok(true);
        }else {
            return ResponseEntity.ok(false);
        }
    }
}
