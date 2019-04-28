package com.netcracker.edu.back.backend.repository;

import com.netcracker.edu.back.backend.entity.BillingAccount;
import com.netcracker.edu.back.backend.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BillingAccountRepository extends CrudRepository<BillingAccount, Integer> {
    List<BillingAccount> findAllByUser(User user);
    BillingAccount findBillingAccountByUserAndName(User user, String name);
}
