package com.netcracker.edu.back.backend.dto;

import com.netcracker.edu.back.backend.entity.Product;
import com.netcracker.edu.back.backend.entity.User;

public class ProductDTO {
    private int id;
    private String description;
    private String name;
    private String videolink;
    private CategoryDTO category;
    private UserDTO user;

    public ProductDTO() {
    }

    public ProductDTO(int id, String description, String name, String videolink, CategoryDTO category, UserDTO user) {
        this.id = id;
        this.description = description;
        this.name = name;
        this.videolink = videolink;
        this.category = category;
        this.user = user;
    }

    public ProductDTO(Product entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.videolink = entity.getVideolink();
        this.category = new CategoryDTO(entity.getCategory());
        this.user = new UserDTO(entity.getUser());
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

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
