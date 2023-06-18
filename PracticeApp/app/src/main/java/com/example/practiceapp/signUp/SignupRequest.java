package com.example.practiceapp.signUp;

public class SignupRequest {
    private String username;
    private String email;
    private String password;

    public SignupRequest(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getusername() {
        return username;
    }

    public void setusername(String username){
        this.username = username;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String password){
        this.password = password;
    }

}
