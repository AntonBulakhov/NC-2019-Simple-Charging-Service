package com.netcracker.edu.fapi.dto;

public class BillingAccount {
    private int id;
    private double sum;
    private String name;
    private User user;

    public BillingAccount() {
    }

    public BillingAccount(int id, double sum, String name, User user) {
        this.id = id;
        this.sum = sum;
        this.name = name;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
