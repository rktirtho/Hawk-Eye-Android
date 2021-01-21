package com.rktirtho.hawkeye.ui.unknowperson;

import android.app.ProgressDialog;
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
import com.rktirtho.hawkeye.adapter.StrangerAdapter;
import com.rktirtho.hawkeye.client.RetrofitClient;
import com.rktirtho.hawkeye.model.Stranger;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UnknownPersonFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private ProgressDialog progressDoalog;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_unknow_person, container, false);
        final ListView lvStranger = root.findViewById(R.id.lv_stranger);
        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                progressDoalog = new ProgressDialog(getContext());
                progressDoalog.setMax(100);
                progressDoalog.setMessage("Fatching Data....");
                progressDoalog.setTitle("Please Wait");
                progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDoalog.show();
                progressDoalog.dismiss();

                Call<List<Stranger>> call = RetrofitClient
                        .getInstance()
                        .getStrangerService()
                        .getAll();

                call.enqueue(new Callback<List<Stranger>>() {
                    @Override
                    public void onResponse(Call<List<Stranger>> call, Response<List<Stranger>> response) {
                        if (response.isSuccessful()){
                            List<Stranger>  strangers = response.body();

                            StrangerAdapter adapter = new StrangerAdapter(getContext(), R.layout.model_stranger, strangers );
                            lvStranger.setAdapter(adapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Stranger>> call, Throwable t) {

                    }
                });



            }
        });
        return root;
    }
}