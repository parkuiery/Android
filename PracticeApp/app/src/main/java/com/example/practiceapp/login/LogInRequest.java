package com.example.practiceapp.login;

public class LogInRequest {

    private String userId;
    private String userPw;

    public LogInRequest(String userId, String userPw){
        this.userId = userId;
        this.userPw = userPw;
    }

    public String getUserId(){
        return userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw){
        this.userPw = userPw;
    }
}
