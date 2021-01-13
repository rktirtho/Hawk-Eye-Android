package com.rktirtho.hawkeye.ui.employees;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.rktirtho.hawkeye.R;
import com.rktirtho.hawkeye.adapter.EmployeesAdapter;
import com.rktirtho.hawkeye.client.RetrofitClient;
import com.rktirtho.hawkeye.model.Employees;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeeFragment extends Fragment {

    private EmployeeViewModel slideshowViewModel;
    private ProgressDialog progressDoalog;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                new ViewModelProvider(this).get(EmployeeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_employees, container, false);
        final ListView textView = root.findViewById(R.id.text_slideshow);
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                progressDoalog = new ProgressDialog(getContext());
                progressDoalog.setMax(100);
                progressDoalog.setMessage("Fatching Data....");
                progressDoalog.setTitle("Please Wait");
                progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDoalog.show();

                Call<List<Employees>> call = RetrofitClient
                        .getInstance()
                        .getEmployeeService()
                        .getAll();

                call.enqueue(new Callback<List<Employees>>() {
                    @Override
                    public void onResponse(Call<List<Employees>> call, Response<List<Employees>> response) {
                        List<Employees> employees = response.body();

                        EmployeesAdapter adapter = new EmployeesAdapter(getContext(), R.layout.model_employee, employees);
                        textView.setAdapter(adapter);
                        progressDoalog.dismiss();
                    }

                    @Override
                    public void onFailure(Call<List<Employees>> call, Throwable t) {
                        progressDoalog.dismiss();
                    }
                });


            }
        });
        return root;
    }
}