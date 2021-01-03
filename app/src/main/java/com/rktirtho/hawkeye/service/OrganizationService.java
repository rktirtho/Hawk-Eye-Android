package com.rktirtho.hawkeye.service;

import com.rktirtho.hawkeye.model.About;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OrganizationService {

    @GET("/url")
    Call<List<About>> getAll();


}
