package com.netcracker.edu.fapi.dto;

public class Product {
    private int id;
    private String description;
    private String name;
    private String logoUrl;
    private String videolink;
    private Category category;
    private User user;

    public Product() {
    }

    public Product(int id, String description, String name, String logoUrl, String videolink, Category category, User user) {
        this.id = id;
        this.description = description;
        this.name = name;
        this.logoUrl = logoUrl;
        this.videolink = videolink;
        this.category = category;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideolink() {
        return videolink;
    }

    public void setVideolink(String videolink) {
        this.videolink = videolink;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}
