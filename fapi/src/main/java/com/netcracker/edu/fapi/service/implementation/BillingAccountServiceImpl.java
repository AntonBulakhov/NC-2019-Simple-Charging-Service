package com.netcracker.edu.fapi.service.implementation;

import com.netcracker.edu.fapi.dto.BillingAccount;
import com.netcracker.edu.fapi.service.BillingAccountService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class BillingAccountServiceImpl implements BillingAccountService {
    @Value("${backend.server.url}")
    private String backendURL;

    @Override
    public List<BillingAccount> getBAByUserId(int id) {
        RestTemplate restTemplate = new RestTemplate();
        BillingAccount[] billingAccounts = restTemplate.getForObject(backendURL + "/api/baccounts/all/user/"+id, BillingAccount[].class);
        return billingAccounts == null ? Collections.emptyList() : Arrays.asList(billingAccounts);
    }

    @Override
    public void updateBillingAccount(BillingAccount billingAccount) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(backendURL + "/api/baccounts", billingAccount);
    }

    @Override
    public BillingAccount createBillingAccount(BillingAccount billingAccount) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(backendURL + "/api/baccounts", billingAccount, BillingAccount.class);
    }

    @Override
    public void deleteBillingAccount(int id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendURL + "/api/baccounts/"+id);
    }

    @Override
    public BillingAccount checkBA(int userId, String name) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendURL + "/api/baccounts/user/"+userId+"/name/"+name, BillingAccount.class);
    }
}
