package com.netcracker.edu.back.backend.controller;

import com.netcracker.edu.back.backend.entity.BillingAccount;
import com.netcracker.edu.back.backend.entity.User;
import com.netcracker.edu.back.backend.service.BillingAccountService;
import com.netcracker.edu.back.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/baccounts")
public class BillingAccountController {
    @Autowired
    private BillingAccountService billingAccountService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/all/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<BillingAccount>> getBillingAccountsByUser(@PathVariable int id){
        Optional<User> user = userService.findById(id);
        if(user.isPresent()){
            return ResponseEntity.ok(billingAccountService.findAllByUser(user.get()));
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public BillingAccount updateBillingAccount(@RequestBody BillingAccount billingAccount){
        Optional<BillingAccount> findBA = billingAccountService.finById(billingAccount.getId());
        if(findBA.isPresent()){
            BillingAccount newBA = findBA.get();
            newBA.setSum(billingAccount.getSum());
            return billingAccountService.save(newBA);
        }else {
            return null;
        }
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public BillingAccount createBillingAccount(@RequestBody BillingAccount newBA){
        return billingAccountService.save(newBA);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteBillingAccount(@PathVariable int id){
        billingAccountService.deleteBillingAccount(id);
    }

    @RequestMapping(value = "/user/{id}/name/{name}")
    public BillingAccount findBillingAccountByName(@PathVariable int id, @PathVariable String name){
        Optional<User> user = userService.findById(id);
        return billingAccountService.checkBA(user.get(), name);
    }
}
