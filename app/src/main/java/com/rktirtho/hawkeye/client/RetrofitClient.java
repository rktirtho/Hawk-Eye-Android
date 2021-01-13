package com.rktirtho.hawkeye.client;

import com.rktirtho.hawkeye.service.EmployeeService;
import com.rktirtho.hawkeye.service.MonitoringService;
import com.rktirtho.hawkeye.service.OrganizationService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static final String BASE_URL = "http://10.0.2.2:8080/";
    private static RetrofitClient retrofitClient;
    private Retrofit retrofit;

    private RetrofitClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
//                .client(getUnsafeOkHttpClient().build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitClient getInstance() {
        if (retrofitClient == null) {
            retrofitClient = new RetrofitClient();
        }
        return retrofitClient;
    }


    //    ================================== Organization Client======================
    public OrganizationService getOrganizatonService() {
        return retrofit.create(OrganizationService.class);
    }


    //    ==================================Employee Client ==========================
    public EmployeeService getEmployeeService() {
        return retrofit.create(EmployeeService.class);
    }

    public MonitoringService getMonitoringService() {
        return retrofit.create(MonitoringService.class);
    }
}


