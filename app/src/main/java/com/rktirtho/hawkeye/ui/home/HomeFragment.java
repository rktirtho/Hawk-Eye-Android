package com.rktirtho.hawkeye.ui.home;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.rktirtho.hawkeye.R;
import com.rktirtho.hawkeye.client.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private ProgressDialog progressDoalog;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        final TextView tv_total_emp = root.findViewById(R.id.tv_total_emp);
        final TextView tv_current_emp = root.findViewById(R.id.tv_current_emp);
        final TextView tv_total_visitor = root.findViewById(R.id.tv_total_visitor);
        final TextView tv_current_visitor = root.findViewById(R.id.tv_current_visitor);
        final TextView tv_num_org = root.findViewById(R.id.tv_num_org);
//        final TextView textView = root.findViewById(R.id.text_home);
//        final TextView textView = root.findViewById(R.id.text_home);
//        final TextView textView = root.findViewById(R.id.text_home);
//        final TextView textView = root.findViewById(R.id.text_home);
//        final TextView textView = root.findViewById(R.id.text_home);
//        final TextView textView = root.findViewById(R.id.text_home);


        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                progressDoalog = new ProgressDialog(getContext());
                progressDoalog.setMax(100);
                progressDoalog.setMessage("Fatching Data....");
                progressDoalog.setTitle("Please Wait");
                progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDoalog.show();
                textView.setText(s);
                progressDoalog.dismiss();

                Call<Long> orgCall = RetrofitClient
                        .getInstance()
                        .getOrganizatonService()
                        .count();

                orgCall.enqueue(new Callback<Long>() {
                    @Override
                    public void onResponse(Call<Long> call, Response<Long> response) {
                        tv_num_org.setText(""+response.body());
                    }

                    @Override
                    public void onFailure(Call<Long> call, Throwable t) {

                    }
                });

                Call<Long> employeeCall = RetrofitClient
                        .getInstance()
                        .getEmployeeService()
                        .count();
                employeeCall.enqueue(new Callback<Long>() {
                    @Override
                    public void onResponse(Call<Long> call, Response<Long> response) {
                        if (response.isSuccessful()){
                            tv_total_emp.setText(""+response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<Long> call, Throwable t) {

                    }
                });

                Call<Long> strangerCall = RetrofitClient
                        .getInstance()
                        .getStrangerService()
                        .count();

                strangerCall.enqueue(new Callback<Long>() {
                    @Override
                    public void onResponse(Call<Long> call, Response<Long> response) {
                        if (response.isSuccessful()){
                            tv_total_visitor.setText(""+response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<Long> call, Throwable t) {

                    }
                });

                Call<Long> todayEmployeeCall = RetrofitClient
                        .getInstance()
                        .getMonitoringService()
                        .countTodayEmployee();

                todayEmployeeCall.enqueue(new Callback<Long>() {
                    @Override
                    public void onResponse(Call<Long> call, Response<Long> response) {
                        tv_current_emp.setText(""+response.body());
                    }

                    @Override
                    public void onFailure(Call<Long> call, Throwable t) {

                    }
                });

                Call<Long> todayVisitorsCall = RetrofitClient
                        .getInstance()
                        .getStrangerService()
                        .countTodayVisitors();
                todayVisitorsCall.enqueue(new Callback<Long>() {
                    @Override
                    public void onResponse(Call<Long> call, Response<Long> response) {
                        tv_current_visitor.setText(""+response.body());
                    }

                    @Override
                    public void onFailure(Call<Long> call, Throwable t) {

                    }
                });
            }
        });
        return root;
    }
}