package com.netcracker.edu.back.backend.controller;

import com.netcracker.edu.back.backend.entity.BillingAccount;
import com.netcracker.edu.back.backend.service.BillingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/billing_account")
public class BillingAccountController {
    @Autowired
    private BillingAccountService billingAccountService;

    @RequestMapping(value = "/get_billing_account/{id}", method = RequestMethod.GET)
    public ResponseEntity<BillingAccount> getBillingAccountById(@PathVariable(name = "id") Long id){
        Optional<BillingAccount> billingAccount = billingAccountService.finById(id);
        return ResponseEntity.ok(billingAccount.get());
    }
}
