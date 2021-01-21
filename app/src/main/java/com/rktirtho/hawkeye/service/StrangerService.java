package com.rktirtho.hawkeye.service;

import com.rktirtho.hawkeye.model.Stranger;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StrangerService {

    @GET
    Call<List<Stranger>> getAll();
}
