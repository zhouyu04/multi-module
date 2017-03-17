package com.zzyy.rs.entities;

public class User {
    private Integer id;

    private String username;

    private String password;

    private String actualname;

    private Boolean valid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getActualname() {
        return actualname;
    }

    public void setActualname(String actualname) {
        this.actualname = actualname == null ? null : actualname.trim();
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}