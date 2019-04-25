package com.netcracker.edu.back.backend.dto;

import com.netcracker.edu.back.backend.entity.Role;

public class UserDTO {
    private int id;
    private String email;
    private String logoUrl;
    private byte blocked;
    private String firstname;
    private String secondname;
    private Role role;

    public UserDTO() {
    }

    public UserDTO(int id, String email, String logoUrl, byte blocked, String firstname, String secondname, Role role) {
        this.id = id;
        this.email = email;
        this.logoUrl = logoUrl;
        this.blocked = blocked;
        this.firstname = firstname;
        this.secondname = secondname;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public byte getBlocked() {
        return blocked;
    }

    public void setBlocked(byte blocked) {
        this.blocked = blocked;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
