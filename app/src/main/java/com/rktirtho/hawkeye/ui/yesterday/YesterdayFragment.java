package com.rktirtho.hawkeye.ui.yesterday;

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
import com.rktirtho.hawkeye.model.About;

import java.util.ArrayList;
import java.util.List;

public class YesterdayFragment extends Fragment {

    private YesterdayViewModel homeViewModel;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel =
                new ViewModelProvider(this).get(YesterdayViewModel.class);
        View root = inflater.inflate(R.layout.fragment_yesterday, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);

            }
        });
        return root;
    }
}