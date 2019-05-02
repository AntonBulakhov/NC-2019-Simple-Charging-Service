package com.netcracker.edu.back.backend.converter;

import com.netcracker.edu.back.backend.dto.BillingAccountDTO;
import com.netcracker.edu.back.backend.entity.BillingAccount;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;

public class BillingToBillingDTO implements Converter<BillingAccount, BillingAccountDTO> {
    private UserToUserDTO toUserDTO = new UserToUserDTO();

    @Override
    public BillingAccountDTO convert(BillingAccount ba) {
       BillingAccountDTO dto = new BillingAccountDTO();
        dto.setId(ba.getId());
        dto.setName(ba.getName());
        dto.setSum(ba.getSum());
        dto.setUser(toUserDTO.convert(ba.getUser()));
        return dto;
    }

    public List<BillingAccountDTO> convert(List<BillingAccount> bas){
        List<BillingAccountDTO> list = new ArrayList<>();
        for (BillingAccount pro: bas) {
            list.add(convert(pro));
        }
        return list;
    }
}
