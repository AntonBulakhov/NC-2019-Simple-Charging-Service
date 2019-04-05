package com.netcracker.edu.fapi.dto;

import lombok.Data;


public class User {
    private int id;
    private Byte blocked;
    private String email;
    private String firstname;
    private String login;
    private String logourl;
    private String password;
    private String secondname;
    private Role role;

    public User() {
    }

    public User(int id, Byte blocked, String email, String firstname, String login, String logourl, String password, String secondname, Role role) {
        this.id = id;
        this.blocked = blocked;
        this.email = email;
        this.firstname = firstname;
        this.login = login;
        this.logourl = logourl;
        this.password = password;
        this.secondname = secondname;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Byte getBlocked() {
        return blocked;
    }

    public void setBlocked(Byte blocked) {
        this.blocked = blocked;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogourl() {
        return logourl;
    }

    public void setLogourl(String logourl) {
        this.logourl = logourl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
