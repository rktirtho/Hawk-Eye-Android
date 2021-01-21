package com.rktirtho.hawkeye.service;


import com.rktirtho.hawkeye.model.Organization;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OrganizationService {

    @GET("api/organizations")
    Call<List<Organization>> getAll();

    @GET("api/organization/count")
    Call<Long> count();


}
