package com.netcracker.edu.back.backend.controller;

import com.netcracker.edu.back.backend.converter.SubscriptionToSubscriptionDTO;
import com.netcracker.edu.back.backend.dto.SubscriptionDTO;
import com.netcracker.edu.back.backend.entity.BillingAccount;
import com.netcracker.edu.back.backend.entity.Product;
import com.netcracker.edu.back.backend.entity.Subscription;
import com.netcracker.edu.back.backend.entity.User;
import com.netcracker.edu.back.backend.service.BillingAccountService;
import com.netcracker.edu.back.backend.service.ProductService;
import com.netcracker.edu.back.backend.service.SubscriptionService;
import com.netcracker.edu.back.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {
    @Autowired
    private SubscriptionService subscriptionService;
    @Autowired
    private UserService userService;
    @Autowired
    private BillingAccountService billingAccountService;
    @Autowired
    private ProductService productService;

    private SubscriptionToSubscriptionDTO subConverter = new SubscriptionToSubscriptionDTO();

    @RequestMapping(value = "/get_all", method = RequestMethod.GET)
    public List<Subscription> getAllSubscriptions(){
        return subscriptionService.findAll();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public List<SubscriptionDTO> getSubsByUser(@PathVariable int id){
        Optional<User> user = userService.findById(id);
        if (user.isPresent()){
            List<BillingAccount> billingAccounts = billingAccountService.findAllByUser(user.get());
            List<Subscription> subscriptions = subscriptionService.getAllByBillingAccountIn(billingAccounts);
            return subConverter.convert(subscriptions);
        }else {
            return null;
        }

    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public SubscriptionDTO saveSubscription(@RequestBody SubscriptionDTO sub){
        Optional<Product> product = productService.getProductById(sub.getProduct().getId());
        Optional<BillingAccount> billingAccount = billingAccountService.finById(sub.getBillingAccount().getId());
        BillingAccount ba = billingAccount.get();
        ba.setSum(ba.getSum() - product.get().getPrice());

        Subscription subscription = subConverter.reverse(sub);
        subscription.setBillingAccount(billingAccount.get());
        subscription.setProduct(product.get());

        SubscriptionDTO dto = subConverter.convert(subscriptionService.save(subscription));

        billingAccountService.save(ba);

        return dto;
    }

    @RequestMapping(value = "/exist/{id}/{productId}", method = RequestMethod.GET)
    public SubscriptionDTO checkSub(@PathVariable int id, @PathVariable int productId){
        Optional<User> user = userService.findById(id);
        Optional<Product> product = productService.getProductById(productId);
        List<BillingAccount> billingAccounts = billingAccountService.findAllByUser(user.get());

        Subscription subscription = subscriptionService.checkSub(product.get(), billingAccounts);
        return subscription == null? null : subConverter.convert(subscription);
    }
}
