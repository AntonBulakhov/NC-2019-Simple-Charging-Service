package com.netcracker.edu.fapi.dto;

import java.sql.Date;

public class Subscription {
    private int id;
    private Byte blocked;
    private Date enddate;
    private Date purchacedate;
    private BillingAccount biling_account;
    private Product product;

    public Subscription() {
    }

    public Subscription(int id, Byte blocked, Date enddate, Date purchacedate, BillingAccount biling_account, Product product) {
        this.id = id;
        this.blocked = blocked;
        this.enddate = enddate;
        this.purchacedate = purchacedate;
        this.biling_account = biling_account;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Byte getBlocked() {
        return blocked;
    }

    public void setBlocked(Byte blocked) {
        this.blocked = blocked;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Date getPurchacedate() {
        return purchacedate;
    }

    public void setPurchacedate(Date purchacedate) {
        this.purchacedate = purchacedate;
    }

    public BillingAccount getBiling_account() {
        return biling_account;
    }

    public void setBiling_account(BillingAccount biling_account) {
        this.biling_account = biling_account;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
