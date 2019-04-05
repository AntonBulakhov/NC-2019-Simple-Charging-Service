package com.netcracker.edu.back.backend.dto;

import com.netcracker.edu.back.backend.entity.BillingAccount;

public class BillingAccountDTO {
    private int id;
    private String name;
    private Double sum;
    private UserDTO user;

    public BillingAccountDTO() {
    }

    public BillingAccountDTO(int id, String name, Double sum, UserDTO user) {
        this.id = id;
        this.name = name;
        this.sum = sum;
        this.user = user;
    }

    public BillingAccountDTO(BillingAccount entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.sum = entity.getSum();
        this.user = new UserDTO(entity.getUser());
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

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
