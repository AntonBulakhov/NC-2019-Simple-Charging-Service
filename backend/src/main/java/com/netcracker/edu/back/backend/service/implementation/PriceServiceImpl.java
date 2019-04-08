package com.netcracker.edu.back.backend.service.implementation;

import com.netcracker.edu.back.backend.entity.Price;
import com.netcracker.edu.back.backend.repository.PriceRepository;
import com.netcracker.edu.back.backend.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {
    @Autowired
    private PriceRepository priceRepository;

    @Override
    public List<Price> findAll() {
        return (List<Price>)priceRepository.findAll();
    }
}
