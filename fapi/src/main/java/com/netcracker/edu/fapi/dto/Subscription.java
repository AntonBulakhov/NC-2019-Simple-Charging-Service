package com.netcracker.edu.fapi.dto;

import java.sql.Date;

public class Subscription {
    private int id;
    private Date purchacedate;
    private Date enddate;
    private byte blocked;
    private Double discount;
    private Product product;
    private BillingAccount billingAccount;

    public Subscription() {
    }

    public Subscription(int id, Date purchacedate, Date enddate, byte blocked, Double discount, Product product, BillingAccount billingAccount) {
        this.id = id;
        this.purchacedate = purchacedate;
        this.enddate = enddate;
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

    public Date getPurchacedate() {
        return purchacedate;
    }

    public void setPurchacedate(Date purchacedate) {
        this.purchacedate = purchacedate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
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
