package com.netcracker.edu.back.backend.charging;

import com.netcracker.edu.back.backend.entity.BillingAccount;
import com.netcracker.edu.back.backend.entity.Subscription;
import com.netcracker.edu.back.backend.service.BillingAccountService;
import com.netcracker.edu.back.backend.service.SubscriptionService;
import com.netcracker.edu.back.backend.service.implementation.SubscriptionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

@Component
public class ChargingService{
    @Autowired
    private BillingAccountService billingAccountService;
    @Autowired
    private SubscriptionService subscriptionService;

    @Scheduled(fixedDelay = 5000)
    public void chargeMoney() {
        System.out.println(subscriptionService.findAll());
        ArrayList<Subscription> subscriptions = (ArrayList<Subscription>) subscriptionService.findAll();
        ArrayList<BillingAccount> billingAccounts = new ArrayList<>();

        for(Subscription sub: subscriptions){
            BillingAccount billingAccount = sub.getBillingAccount();
            System.out.println(billingAccount.getSum());
            billingAccount.setSum(billingAccount.getSum() - sub.getProduct().getPrice() * (1 - (sub.getDiscount()/100)));
            System.out.println(billingAccount.getSum());
            billingAccounts.add(billingAccount);
        }

        for(BillingAccount ba: billingAccounts){
            billingAccountService.save(ba);
        }
    }
}
