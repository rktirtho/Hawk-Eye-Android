package com.rktirtho.hawkeye.ui.today;

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
import com.rktirtho.hawkeye.adapter.AboutAdapter;
import com.rktirtho.hawkeye.model.About;

import java.util.ArrayList;
import java.util.List;

public class TodayFragment extends Fragment {

    private TodayViewModel homeViewModel;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        List<About> abouts = new ArrayList<>();

        About tirtho = new About("Rejaul Karim", "Code and System Analyst","41", "CS-E-16-105405");
        About sima = new About("Sima Akter", "Book Writing and Data Analyst","07", "CS-E-16-105405");
        About siam = new About("Shaeed Al Hasan", "UI Design and Database Administator","40", "CS-E-16-105405");
        About shuvo = new About("Abdullah Al Shuvo", "Security and Testing","32", "CS-E-16-105405");
        About supervisor = new About("Md. Rafid Mustafiz", "Supervisor","Lecturer", "Dhaka International University");

        abouts.add(supervisor);
        abouts.add(tirtho);
        abouts.add(siam);
        abouts.add(sima);
        abouts.add(shuvo);


        homeViewModel =
                new ViewModelProvider(this).get(TodayViewModel.class);
        View root = inflater.inflate(R.layout.fragment_about, container, false);
        final ListView textView = root.findViewById(R.id.about_list);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                AboutAdapter adapter = new AboutAdapter(getContext(), R.layout.model_about, abouts);
                textView.setAdapter(adapter);

            }
        });
        return root;
    }
}