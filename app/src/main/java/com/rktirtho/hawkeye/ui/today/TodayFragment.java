package com.rktirtho.hawkeye.ui.today;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.rktirtho.hawkeye.R;
import com.rktirtho.hawkeye.adapter.AboutAdapter;
import com.rktirtho.hawkeye.adapter.EmployeesAdapter;
import com.rktirtho.hawkeye.client.RetrofitClient;
import com.rktirtho.hawkeye.model.About;
import com.rktirtho.hawkeye.model.Employees;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TodayFragment extends Fragment {

    private TodayViewModel homeViewModel;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        homeViewModel =
                new ViewModelProvider(this).get(TodayViewModel.class);
        View root = inflater.inflate(R.layout.fragment_today, container, false);
        final ListView listView = root.findViewById(R.id.list_view);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Call<List<Employees>> call = RetrofitClient.getInstance()
                        .getMonitoringService()
                        .getToday();

                call.enqueue(new Callback<List<Employees>>() {
                    @Override
                    public void onResponse(Call<List<Employees>> call, Response<List<Employees>> response) {
                        if (response.isSuccessful()){
                            List<Employees> employees = response.body();
                            EmployeesAdapter adapter = new EmployeesAdapter(getContext(), R.layout.model_employee, employees);
                            listView.setAdapter(adapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Employees>> call, Throwable t) {

                    }
                });

//                textView.setText(s);

            }
        });
        return root;
    }
}