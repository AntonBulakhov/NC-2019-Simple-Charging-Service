package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.dto.Subscription;

import java.util.List;

public interface SubscriptionService {
    Subscription save(Subscription subscription);
    List<Subscription> getSubsByUser(int id);
    Subscription checkSub(int id, int productId);
    void delete(int id);
    Subscription update(Subscription sub);
    Integer getSubsCount(int id);
}
