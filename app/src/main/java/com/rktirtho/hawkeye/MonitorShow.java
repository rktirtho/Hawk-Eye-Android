package com.rktirtho.hawkeye;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ListView;

import com.rktirtho.hawkeye.adapter.MonitoringViewAdapter;
import com.rktirtho.hawkeye.client.RetrofitClient;
import com.rktirtho.hawkeye.model.Employees;
import com.rktirtho.hawkeye.model.MonitoringView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MonitorShow extends AppCompatActivity {
    ListView accessList;
    private ProgressDialog progressDoalog;
    private List<MonitoringView> monitoringViewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor_show);
        init();
        progressDoalog = new ProgressDialog(this);
        progressDoalog.setMax(100);
        progressDoalog.setMessage("Fatching Data....");
        progressDoalog.setTitle("Please Wait");
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDoalog.show();

        int personId = getIntent().getIntExtra("personId",0);

        Call<List<MonitoringView>> call = RetrofitClient.getInstance()
                .getMonitoringService()
                .getAccessView(personId);

        call.enqueue(new Callback<List<MonitoringView>>() {
            @Override
            public void onResponse(Call<List<MonitoringView>> call, Response<List<MonitoringView>> response) {
                if (response.isSuccessful()){
                    monitoringViewList = response.body();
                    MonitoringViewAdapter adapter = new MonitoringViewAdapter(MonitorShow.this, R.layout.model_access, monitoringViewList);
                    accessList.setAdapter(adapter);
                }
                progressDoalog.dismiss();
            }

            @Override
            public void onFailure(Call<List<MonitoringView>> call, Throwable t) {
                progressDoalog.dismiss();
            }
        });



    }

    private void init(){
        accessList = findViewById(R.id.access_list);

    }
}