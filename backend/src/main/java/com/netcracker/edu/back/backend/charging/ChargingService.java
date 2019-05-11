package com.netcracker.edu.back.backend.charging;

import com.netcracker.edu.back.backend.entity.BillingAccount;
import com.netcracker.edu.back.backend.entity.Subscription;
import com.netcracker.edu.back.backend.service.BillingAccountService;
import com.netcracker.edu.back.backend.service.SubscriptionService;
import org.joda.time.LocalDate;
import org.joda.time.MonthDay;
import org.joda.time.Months;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import static java.math.BigDecimal.ROUND_CEILING;

@Component
public class ChargingService{
    @Autowired
    private BillingAccountService billingAccountService;
    @Autowired
    private SubscriptionService subscriptionService;

//    @Scheduled(fixedDelay = 25000)
    @Scheduled(cron = "0 0 0 * * ?")
    public void chargeMoney() {
        Calendar currenttime = Calendar.getInstance();
        Date today = new Date((currenttime.getTime()).getTime());

        ArrayList<Subscription> subscriptions = (ArrayList<Subscription>) subscriptionService.findAll();
        ArrayList<BillingAccount> billingAccounts = new ArrayList<>();

        for(Subscription sub: subscriptions){
            if((sub.getEnddate().getTime()/100000000 - today.getTime()/100000000) < 0){
                subscriptionService.delete(sub);
            }else if(sub.getBlocked() == 0) {
                BillingAccount billingAccount = sub.getBillingAccount();

                double price = sub.getProduct().getPrice() * (1 - (sub.getDiscount()/100));
                if(billingAccount.getSum() < price){
                    sub.setBlocked((byte) 1);
                    subscriptionService.save(sub);
                }else {
                    sub.setBlocked((byte)0);
                    subscriptionService.save(sub);
                    BigDecimal decimal = BigDecimal.valueOf(billingAccount.getSum() - price/30).setScale(2, ROUND_CEILING);
                    billingAccount.setSum(decimal.doubleValue());
                    billingAccounts.add(billingAccount);
                }
            }
        }

        for(BillingAccount ba: billingAccounts){
            billingAccountService.save(ba);
        }
    }
}
