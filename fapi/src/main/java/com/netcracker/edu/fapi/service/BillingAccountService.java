package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.dto.BillingAccount;

import java.util.List;

public interface BillingAccountService {
    List<BillingAccount> getBAByUserId(int id);
    void updateBillingAccount(BillingAccount billingAccount);
    BillingAccount createBillingAccount(BillingAccount billingAccount);
    void deleteBillingAccount(int id);

    BillingAccount checkBA(int userId, String name);
}
