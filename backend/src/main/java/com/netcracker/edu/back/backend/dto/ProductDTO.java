package com.netcracker.edu.back.backend.dto;

import com.netcracker.edu.back.backend.entity.Category;

public class ProductDTO {
    private int id;
    private String name;
    private String description;
    private double price;
    private String logoUrl;
    private UserDTO user;
    private Category category;

    public ProductDTO() {
    }

    public ProductDTO(int id, String name, String description, double price, String logoUrl, UserDTO user, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.logoUrl = logoUrl;
        this.user = user;
        this.category = category;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
