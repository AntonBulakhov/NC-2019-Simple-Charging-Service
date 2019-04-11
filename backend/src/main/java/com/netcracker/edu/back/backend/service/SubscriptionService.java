package com.netcracker.edu.back.backend.service;

import com.netcracker.edu.back.backend.entity.Subscription;

import java.util.List;

public interface SubscriptionService {
    List<Subscription> findAll();
    List<Subscription> getTopFourSubs();

}
