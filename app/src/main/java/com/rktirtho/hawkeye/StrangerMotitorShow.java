package com.rktirtho.hawkeye;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.rktirtho.hawkeye.adapter.StrangerMonitoringViewAdapter;
import com.rktirtho.hawkeye.client.RetrofitClient;
import com.rktirtho.hawkeye.model.MonitoringView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StrangerMotitorShow extends AppCompatActivity {
    private ImageView ivImage;
    private TextView tvStName;
    private ListView lvStng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stranger_motitor_show);
        init();
        int stId = getIntent().getIntExtra("stId",0);
        String stImage = getIntent().getStringExtra("stImage");

//        Glide.with(this)
//                .load(RetrofitClient.BASE_URL+"images/"+stImage+".jpg")
//                .placeholder(R.drawable.logo)
//                .error(R.drawable.logo)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(ivImage);

        tvStName.setText(stImage);


        Call<List<MonitoringView>> call = RetrofitClient
                .getInstance()
                .getStrangerService()
                .getAccessById(stId);

        call.enqueue(new Callback<List<MonitoringView>>() {
            @Override
            public void onResponse(Call<List<MonitoringView>> call, Response<List<MonitoringView>> response) {
                if(response.isSuccessful()){
                    List<MonitoringView> views =response.body();
                    StrangerMonitoringViewAdapter adapter = new StrangerMonitoringViewAdapter(getApplicationContext(), R.layout.model_stranger_access, views);
                    lvStng.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<MonitoringView>> call, Throwable t) {

            }
        });


    }

    private void init(){

        ivImage = findViewById(R.id.iv_image);
        tvStName = findViewById(R.id.tv_st_name);
        lvStng = findViewById(R.id.lv_stranger_access);

    }
}