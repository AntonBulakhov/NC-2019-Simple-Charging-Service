package com.netcracker.edu.back.backend.service;

import com.netcracker.edu.back.backend.entity.BillingAccount;
import com.netcracker.edu.back.backend.entity.Product;
import com.netcracker.edu.back.backend.entity.Subscription;

import java.util.List;

public interface SubscriptionService {
    Subscription save(Subscription subscription);
    List<Subscription> findAll();
    List<Subscription> getTopFourSubs();
    List<Subscription> getAllByBillingAccount(BillingAccount billingAccount);
    List<Subscription> getAllByBillingAccountIn(List<BillingAccount> billingAccounts);
    Subscription checkSub(Product product, List<BillingAccount> billingAccounts);
}
