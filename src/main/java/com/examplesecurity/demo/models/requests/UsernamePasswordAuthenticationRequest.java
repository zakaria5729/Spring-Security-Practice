package com.examplesecurity.demo.models.requests;

public class UsernamePasswordAuthenticationRequest {
    private String username;
    private String password;

    public UsernamePasswordAuthenticationRequest() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
