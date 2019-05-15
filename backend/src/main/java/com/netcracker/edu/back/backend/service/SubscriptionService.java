package com.netcracker.edu.back.backend.service;

import com.netcracker.edu.back.backend.entity.BillingAccount;
import com.netcracker.edu.back.backend.entity.Product;
import com.netcracker.edu.back.backend.entity.Subscription;

import java.util.List;
import java.util.Optional;

public interface SubscriptionService {
    Subscription save(Subscription subscription);
    List<Subscription> findAll();
    List<Subscription> getTopFourSubs();
    Integer countAllByProduct(Product product);
    void deleteAllByProduct(Product product);
    List<Subscription> getAllByBillingAccount(BillingAccount billingAccount);
    List<Subscription> getAllByBillingAccountIn(List<BillingAccount> billingAccounts);
    Subscription checkSub(Product product, List<BillingAccount> billingAccounts);
    void delete(Subscription sub);
    Optional<Subscription> findById(int id);
}
