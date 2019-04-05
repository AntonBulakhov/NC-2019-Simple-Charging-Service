package com.netcracker.edu.back.backend.dto;

import com.netcracker.edu.back.backend.entity.Price;

public class PriceDTO {
    private int id;
    private Byte period;
    private Double price;
    private ProductDTO product;

    public PriceDTO() {
    }

    public PriceDTO(int id, Byte period, Double price, ProductDTO product) {
        this.id = id;
        this.period = period;
        this.price = price;
        this.product = product;
    }

    public PriceDTO(Price entity) {
        this.id = entity.getId();
        this.period = entity.getPeriod();
        this.price = entity.getPrice();
        this.product = new ProductDTO(entity.getProduct());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Byte getPeriod() {
        return period;
    }

    public void setPeriod(Byte period) {
        this.period = period;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }
}
