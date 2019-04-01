package com.netcracker.edu.back.backend.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "subscription", schema = "chargingdb", catalog = "")
public class Subscription {
    private int id;
    private Byte blocked;
    private Date enddate;
    private Date purchacedate;
    private BillingAccount biling_account;
    private Product product;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "blocked")
    public Byte getBlocked() {
        return blocked;
    }

    public void setBlocked(Byte blocked) {
        this.blocked = blocked;
    }

    @Basic
    @Column(name = "enddate")
    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    @Basic
    @Column(name = "purchacedate")
    public Date getPurchacedate() {
        return purchacedate;
    }

    public void setPurchacedate(Date purchacedate) {
        this.purchacedate = purchacedate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return id == that.id &&
                Objects.equals(blocked, that.blocked) &&
                Objects.equals(enddate, that.enddate) &&
                Objects.equals(purchacedate, that.purchacedate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, blocked, enddate, purchacedate);
    }

    @ManyToOne
    public BillingAccount getBiling_account() {
        return biling_account;
    }

    public void setBiling_account(BillingAccount biling_account) {
        this.biling_account = biling_account;
    }

    @ManyToOne
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
