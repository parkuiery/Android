package com.example.practiceapp.login;

public class LogInRequest {

    private String username;
    private String password;

    public LogInRequest(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String get(){
        return username;
    }

    public void set(String username){
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
