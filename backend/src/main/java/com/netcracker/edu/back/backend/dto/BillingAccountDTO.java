package com.netcracker.edu.back.backend.dto;

public class BillingAccountDTO {
    private int id;
    private double sum;
    private String name;
    private UserDTO user;

    public BillingAccountDTO() {
    }

    public BillingAccountDTO(int id, double sum, String name, UserDTO user) {
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

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
