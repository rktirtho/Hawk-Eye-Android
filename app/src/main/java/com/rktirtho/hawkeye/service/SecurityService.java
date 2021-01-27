package com.rktirtho.hawkeye.service;

import com.rktirtho.hawkeye.model.Employees;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SecurityService {

    @GET("api/securityofficer/login/{username}/{password}")
    Call<Boolean> login(@Path("username") String username, @Path("password") String password);
}
