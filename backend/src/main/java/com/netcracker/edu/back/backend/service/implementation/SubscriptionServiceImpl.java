package com.netcracker.edu.back.backend.service.implementation;

import com.netcracker.edu.back.backend.entity.Subscription;
import com.netcracker.edu.back.backend.repository.SubscriptionRepository;
import com.netcracker.edu.back.backend.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Override
    public List<Subscription> findAll() {
        return (List<Subscription>)subscriptionRepository.findAll();
    }

    @Override
    public List<Subscription> getTopFourSubs() {
        return subscriptionRepository.getTopFourSubs();
    }
}
