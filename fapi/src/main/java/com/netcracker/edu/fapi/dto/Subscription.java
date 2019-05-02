package com.netcracker.edu.fapi.dto;

public class Subscription {
    private int id;
    private int time;
    private byte blocked;
    private Double discount;
    private Product product;
    private BillingAccount billingAccount;

    public Subscription() {
    }

    public Subscription(int id, int time, byte blocked, Double discount, Product product, BillingAccount billingAccount) {
        this.id = id;
        this.time = time;
        this.blocked = blocked;
        this.discount = discount;
        this.product = product;
        this.billingAccount = billingAccount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public byte getBlocked() {
        return blocked;
    }

    public void setBlocked(byte blocked) {
        this.blocked = blocked;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BillingAccount getBillingAccount() {
        return billingAccount;
    }

    public void setBillingAccount(BillingAccount billingAccount) {
        this.billingAccount = billingAccount;
    }
}
