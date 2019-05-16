package com.netcracker.edu.back.backend.dto;

public class SubscriptionDTO {
    private int id;
    private int time;
    private byte blocked;
    private Double discount;
    private ProductDTO product;
    private BillingAccountDTO billingAccount;

    public SubscriptionDTO() {
    }

    public SubscriptionDTO(int id, int time, byte blocked, Double discount, ProductDTO product, BillingAccountDTO billingAccount) {
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

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public BillingAccountDTO getBillingAccount() {
        return billingAccount;
    }

    public void setBillingAccount(BillingAccountDTO billingAccount) {
        this.billingAccount = billingAccount;
    }
}
