package com.netcracker.edu.back.backend.controller;

import com.netcracker.edu.back.backend.entity.Price;
import com.netcracker.edu.back.backend.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/price")
public class PriceController {
    @Autowired
    private PriceService priceService;

    @RequestMapping(value = "/get_all", method = RequestMethod.GET)
    public List<Price> getAllPrices(){
        return priceService.findAll();
    }
}
