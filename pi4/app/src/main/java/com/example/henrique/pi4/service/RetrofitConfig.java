package com.example.henrique.pi4.service;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;


public class RetrofitConfig {
    private final Retrofit retrofit;

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("http://werbservice.azurewebsites.net/LoginWebService/ws/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public LOGINService getLOGINService() {
        return this.retrofit.create(LOGINService.class);
    }

}
