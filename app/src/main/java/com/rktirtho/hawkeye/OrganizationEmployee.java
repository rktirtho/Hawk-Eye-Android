package com.rktirtho.hawkeye;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.rktirtho.hawkeye.adapter.EmployeesAdapter;
import com.rktirtho.hawkeye.client.RetrofitClient;
import com.rktirtho.hawkeye.model.Employees;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrganizationEmployee extends AppCompatActivity {

    private ListView orgEmployee ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization_employee);
        init();
        int orgId = getIntent().getIntExtra("orgId",0);

        Call<List<Employees>> call = RetrofitClient
                .getInstance()
                .getEmployeeService()
                .getAllByorgId(orgId);
        call.enqueue(new Callback<List<Employees>>() {
            @Override
            public void onResponse(Call<List<Employees>> call, Response<List<Employees>> response) {
                List<Employees> employees = response.body();

                EmployeesAdapter adapter = new EmployeesAdapter(OrganizationEmployee.this, R.layout.model_employee, employees);
                orgEmployee.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Employees>> call, Throwable t) {

            }
        });




    }

    private void init(){
        orgEmployee = findViewById(R.id.lv_org_emp);
    }
}