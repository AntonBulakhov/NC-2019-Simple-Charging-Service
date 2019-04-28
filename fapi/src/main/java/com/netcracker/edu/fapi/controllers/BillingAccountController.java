package com.netcracker.edu.fapi.controllers;

import com.netcracker.edu.fapi.dto.BillingAccount;
import com.netcracker.edu.fapi.service.BillingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/baccounts")
public class BillingAccountController {
    @Autowired
    private BillingAccountService billingAccountService;

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/all/user/{id}")
    public ResponseEntity<List<BillingAccount>> getAll(@PathVariable int id){
        List<BillingAccount> billingAccounts = billingAccountService.getBAByUserId(id);
        if(!billingAccounts.isEmpty()){
            return ResponseEntity.ok(billingAccounts);
        }else {
            return ResponseEntity.ok(null);
        }
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PutMapping("")
    public ResponseEntity<BillingAccount> updateBillingAccount(@RequestBody BillingAccount billingAccount){
        billingAccountService.updateBillingAccount(billingAccount);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping("")
    public ResponseEntity<BillingAccount> createBillingAccount(@RequestBody BillingAccount newBA){
        BillingAccount billingAccount = billingAccountService.createBillingAccount(newBA);
        if(billingAccount != null){
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.badRequest().build();
        }
    }


    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteBillingAccount(@PathVariable int id){
        billingAccountService.deleteBillingAccount(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/{id}/name/{name}")
    public ResponseEntity<Boolean> checkBillingAccountByName(@PathVariable int id, @PathVariable String name){
        BillingAccount billingAccount = billingAccountService.checkBA(id, name);
        if(billingAccount != null){
            return ResponseEntity.ok(true);
        }else {
            return ResponseEntity.ok(false);
        }
    }
}
