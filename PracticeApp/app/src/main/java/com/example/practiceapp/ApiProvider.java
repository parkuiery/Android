package com.example.practiceapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiProvider {
    private static Retrofit retrofit;
    private static String BASE_URL = "";

    public static Retrofit getInstnace() {
        if(retrofit==null){
            retrofit= new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
