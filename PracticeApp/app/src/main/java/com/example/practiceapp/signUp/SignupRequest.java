package com.example.practiceapp.signUp;

public class SignupRequest {
    private String userId;
    private String userPw;
    private String userPwcheck;

    public SignupRequest(String userId, String userPw, String userPwcheck){
        this.userId = userId;
        this.userPw = userPw;
        this.userPwcheck = userPwcheck;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public String getUserPwcheck() {
        return userPwcheck;
    }

    public void setUserPwcheck(String userPwcheck){
        this.userPwcheck = userPwcheck;
    }

}
