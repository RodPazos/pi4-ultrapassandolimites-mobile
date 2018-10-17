package com.example.henrique.pi4.service;

import com.example.henrique.pi4.Model.Login;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface LOGINService {
    @GET("login/Usuario/get/{email}/{senha}")
    Call<Login> buscarUsuario(@Path("email") String email, @Path("senha") String senha);
}