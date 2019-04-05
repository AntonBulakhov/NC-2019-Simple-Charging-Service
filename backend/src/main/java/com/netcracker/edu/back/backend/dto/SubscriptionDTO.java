package com.netcracker.edu.back.backend.dto;

import com.netcracker.edu.back.backend.entity.Subscription;

import java.sql.Date;

public class SubscriptionDTO {
    private int id;
    private Byte blocked;
    private Date enddate;
    private Date purchacedate;
    private BillingAccountDTO biling_account;
    private ProductDTO product;

    public SubscriptionDTO() {
    }

    public SubscriptionDTO(int id, Byte blocked, Date enddate, Date purchacedate, BillingAccountDTO biling_account, ProductDTO product) {
        this.id = id;
        this.blocked = blocked;
        this.enddate = enddate;
        this.purchacedate = purchacedate;
        this.biling_account = biling_account;
        this.product = product;
    }

    public SubscriptionDTO(Subscription entity) {
        this.id = entity.getId();
        this.blocked = entity.getBlocked();
        this.enddate = entity.getEnddate();
        this.purchacedate = entity.getPurchacedate();
        this.biling_account = new BillingAccountDTO(entity.getBiling_account());
        this.product = new ProductDTO(entity.getProduct());
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

    public BillingAccountDTO getBiling_account() {
        return biling_account;
    }

    public void setBiling_account(BillingAccountDTO biling_account) {
        this.biling_account = biling_account;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }
}
