package com.example.practiceapp;

import com.example.practiceapp.login.LogInRequest;
import com.example.practiceapp.login.LogInResponse;
import com.example.practiceapp.signUp.SignupRequest;
import com.example.practiceapp.signUp.SignupResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SeverApi {

    @POST("/login")
    Call<LogInResponse> Login (
            @Body LogInRequest logInRequest
    );

    @POST("/signup")
    Call<SignupResponse> Signup (
            @Body SignupRequest signupRequest
    );




}
