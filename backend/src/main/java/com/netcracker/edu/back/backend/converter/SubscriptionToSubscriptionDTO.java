package com.netcracker.edu.back.backend.converter;

import com.netcracker.edu.back.backend.dto.SubscriptionDTO;
import com.netcracker.edu.back.backend.entity.Subscription;
import org.springframework.core.convert.converter.Converter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SubscriptionToSubscriptionDTO implements Converter<Subscription, SubscriptionDTO> {
    private ProductToProductDTO productConverter = new ProductToProductDTO();
    private BillingToBillingDTO billingConverter = new BillingToBillingDTO();

    @Override
    public SubscriptionDTO convert(Subscription sub) {
        SubscriptionDTO dto = new SubscriptionDTO();
        dto.setId(sub.getId());
        dto.setBlocked(sub.getBlocked());
        dto.setTime(getDaysLeft(sub));
        dto.setDiscount(sub.getDiscount());
        dto.setProduct(productConverter.convert(sub.getProduct()));
        dto.setBillingAccount(billingConverter.convert(sub.getBillingAccount()));
        return dto;
    }

    private int getDaysLeft(Subscription sub){
        Date start = sub.getPurchacedate();
        Date end = sub.getEnddate();
        long time = end.getTime() - start.getTime();
        return (int) (time / (24 * 60 * 60 * 1000));
    }

    public Subscription reverse(SubscriptionDTO dto){
        Subscription sub = new Subscription();
        sub.setBlocked(dto.getBlocked());
        sub.setDiscount(dto.getDiscount());

        Calendar calendar = Calendar.getInstance();
        Date current = new Date(calendar.getTime().getTime());
        sub.setPurchacedate(current);

        calendar.add(Calendar.MONTH, dto.getTime());
        Date end = new Date(calendar.getTime().getTime());
        sub.setEnddate(end);

        return sub;
    }

    public List<SubscriptionDTO> convert(List<Subscription> subs){
        List<SubscriptionDTO> list = new ArrayList<>();
        for (Subscription pro: subs) {
            list.add(convert(pro));
        }
        return list;
    }
}
