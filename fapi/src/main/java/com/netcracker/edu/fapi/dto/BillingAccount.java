package com.netcracker.edu.fapi.dto;

public class BillingAccount {
    private int id;
    private String name;
    private Double sum;
    private User user;

    public BillingAccount() {
    }

    public BillingAccount(int id, String name, Double sum, User user) {
        this.id = id;
        this.name = name;
        this.sum = sum;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
