package com.rktirtho.hawkeye.service;

import com.rktirtho.hawkeye.model.Employees;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface EmployeeService {

    @GET("api/permitteds")
    Call<List<Employees>> getAll();

    @GET("api/permitteds/org/{id}")
    Call<List<Employees>> getAllByorgId(@Path("id") int id);
}
