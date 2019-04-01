package com.netcracker.edu.back.backend.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "chargingdb", catalog = "")
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

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "blocked")
    public Byte getBlocked() {
        return blocked;
    }

    public void setBlocked(Byte blocked) {
        this.blocked = blocked;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "firstname")
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "logourl")
    public String getLogourl() {
        return logourl;
    }

    public void setLogourl(String logourl) {
        this.logourl = logourl;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "secondname")
    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return id == that.id &&
                Objects.equals(blocked, that.blocked) &&
                Objects.equals(email, that.email) &&
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(login, that.login) &&
                Objects.equals(logourl, that.logourl) &&
                Objects.equals(password, that.password) &&
                Objects.equals(secondname, that.secondname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, blocked, email, firstname, login, logourl, password, secondname);
    }

    @ManyToOne(cascade = {CascadeType.ALL})
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
