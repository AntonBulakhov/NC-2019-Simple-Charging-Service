package com.netcracker.edu.back.backend.repository;

import com.netcracker.edu.back.backend.entity.Subscription;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubscriptionRepository extends CrudRepository<Subscription, Long> {
    @Query("select s from Subscription s group by s.product order by count(s.id) desc")
    List<Subscription> getTopFourSubs();
}
