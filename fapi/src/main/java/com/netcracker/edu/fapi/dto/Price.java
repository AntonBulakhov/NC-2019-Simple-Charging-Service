package com.netcracker.edu.fapi.dto;

public class Price {
    private int id;
    private Byte period;
    private Double price;
    private Product product;

    public Price() {
    }

    public Price(int id, Byte period, Double price, Product product) {
        this.id = id;
        this.period = period;
        this.price = price;
        this.product = product;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
