package com.netcracker.edu.back.backend.service.implementation;

import com.netcracker.edu.back.backend.entity.BillingAccount;
import com.netcracker.edu.back.backend.repository.BillingAccountRepository;
import com.netcracker.edu.back.backend.service.BillingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillingAccountServiceImpl implements BillingAccountService {
    @Autowired
    private BillingAccountRepository billingAccountRepository;

    @Override
    public BillingAccount save(BillingAccount billingAccount) {
        return billingAccountRepository.save(billingAccount);
    }

    @Override
    public Optional<BillingAccount> finById(Long id) {
        return billingAccountRepository.findById(id);
    }
}
