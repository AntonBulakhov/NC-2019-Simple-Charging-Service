package com.netcracker.edu.back.backend.dto;

import com.netcracker.edu.back.backend.entity.Role;

public class RoleDTO {
    private int id;
    private String name;

    public RoleDTO() {
    }

    public RoleDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public RoleDTO(Role entity) {
        this.id = entity.getId();
        this.name = entity.getName();
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
}
