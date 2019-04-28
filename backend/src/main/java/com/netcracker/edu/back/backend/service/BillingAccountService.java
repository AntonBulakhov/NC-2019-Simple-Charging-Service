package com.netcracker.edu.back.backend.service;

import com.netcracker.edu.back.backend.entity.BillingAccount;
import com.netcracker.edu.back.backend.entity.User;

import java.util.List;
import java.util.Optional;

public interface BillingAccountService {
    BillingAccount save(BillingAccount billingAccount);
    Optional<BillingAccount> finById(Integer id);
    List<BillingAccount> findAllByUser(User user);
    void deleteBillingAccount(int id);

    BillingAccount checkBA(User user, String name);
}
