package com.rktirtho.hawkeye.service;

import com.rktirtho.hawkeye.model.Employees;
import com.rktirtho.hawkeye.model.MonitoringView;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MonitoringService {

    @GET("api/monitoring/today")
    Call<List<Employees>> getToday();

    @GET("api/monitoring/yesterday")
    Call<List<Employees>> getYesterday();

    @GET("api/monitoring/access/authorized")
    Call<List<Employees>> getAuthorizedAccess();

    @GET("api/monitoring/access/unauthorized")
    Call<List<Employees>> getUnauthorizedAccess();

    @GET("")
    Call<List<Employees>> getAccessByEmployeeId();

    @GET("api/monitoring/person/access/auth/{id}")
    Call<List<MonitoringView>> getAccessView(@Path("id") int id);





}
