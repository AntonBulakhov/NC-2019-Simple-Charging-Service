package com.netcracker.edu.fapi.service.implementation;

import com.netcracker.edu.fapi.dto.Subscription;
import com.netcracker.edu.fapi.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Value("${backend.server.url}")
    private String backendURL;

    @Override
    public List<Subscription> getSubsByUser(int id) {
        RestTemplate restTemplate = new RestTemplate();
        Subscription[] subs = restTemplate.getForObject(backendURL + "/api/subscriptions/user/"+id, Subscription[].class);
        return subs  == null ? Collections.emptyList() : Arrays.asList(subs);
    }

    @Override
    public Subscription save(Subscription subscription) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(backendURL + "/api/subscriptions", subscription, Subscription.class);
    }

    @Override
    public Subscription checkSub(int id, int productId) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendURL + "/api/subscriptions/exist/" + id + "/" + productId, Subscription.class);
    }

    @Override
    public void delete(int id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendURL+ "/api/subscriptions/del/"+id);
    }

    @Override
    public Subscription update(Subscription sub) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(backendURL + "/api/subscriptions/upd", sub, Subscription.class);
    }
}
