package com.netcracker.edu.back.backend.repository;

import com.netcracker.edu.back.backend.entity.BillingAccount;
import com.netcracker.edu.back.backend.entity.Product;
import com.netcracker.edu.back.backend.entity.Subscription;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SubscriptionRepository extends CrudRepository<Subscription, Integer> {
    @Query("select s from Subscription s group by s.product order by count(s.id) desc")
    List<Subscription> getTopFourSubs();

    Integer countAllByProduct(Product product);

    @Transactional
    void deleteAllByProductIn(Product product);

    @Transactional
    void deleteAllByBillingAccountIn(BillingAccount billingAccount);

    List<Subscription> getAllByBillingAccount(BillingAccount billingAccount);
    List<Subscription> getAllByBillingAccountIn(List<BillingAccount> billingAccounts);

    Subscription getByProductAndBillingAccountIn(Product product, List<BillingAccount> billingAccounts);
}
