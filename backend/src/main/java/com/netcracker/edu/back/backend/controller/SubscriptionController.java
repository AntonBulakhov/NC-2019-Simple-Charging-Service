package com.netcracker.edu.back.backend.controller;

import com.netcracker.edu.back.backend.entity.Subscription;
import com.netcracker.edu.back.backend.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/subscription")
public class SubscriptionController {
    @Autowired
    private SubscriptionService subscriptionService;

    @RequestMapping(value = "/get_all", method = RequestMethod.GET)
    public List<Subscription> getAllSubscriptions(){
        return subscriptionService.findAll();
    }
}
