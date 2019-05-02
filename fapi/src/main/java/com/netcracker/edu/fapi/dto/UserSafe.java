package com.netcracker.edu.fapi.dto;

public class UserSafe {
    private int id;
    private String email;
    private String logoUrl;
    private String firstname;
    private String secondname;
    private Role role;

    public UserSafe() {
    }

    public UserSafe(int id, String email, String logoUrl, String firstname, String secondname, Role role) {
        this.id = id;
        this.email = email;
        this.logoUrl = logoUrl;
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
