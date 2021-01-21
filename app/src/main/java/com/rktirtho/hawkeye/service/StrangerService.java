package com.rktirtho.hawkeye.service;

import com.rktirtho.hawkeye.model.MonitoringView;
import com.rktirtho.hawkeye.model.Stranger;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface StrangerService {

    @GET("api/stranger/all")
    Call<List<Stranger>> getAll();

    @GET("api/stranger/access/{id}")
    Call<List<MonitoringView>> getAccessById(@Path("id") int id);
}
