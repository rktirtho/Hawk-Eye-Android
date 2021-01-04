package com.rktirtho.hawkeye.ui.organizations;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.rktirtho.hawkeye.R;
import com.rktirtho.hawkeye.client.RetrofitClient;
import com.rktirtho.hawkeye.model.About;
import com.rktirtho.hawkeye.model.Organization;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrganizationFragment extends Fragment {

    private OrganizationViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(OrganizationViewModel.class);
        View root = inflater.inflate(R.layout.fragment_organizations, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);

                Call<List<Organization>> call = RetrofitClient.getInstance()
                        .getOrganizatonService()
                        .getAll();

                call.enqueue(new Callback<List<Organization>>() {
                    @Override
                    public void onResponse(Call<List<Organization>> call, Response<List<Organization>> response) {
                        if (response.isSuccessful()) {
                            List<Organization> organizations = response.body();
                            for (Organization organization: organizations
                                 ) {
                                Toast.makeText(getContext(),organization.getName() , Toast.LENGTH_SHORT).show();

                            }

                        } else {
                            Toast.makeText(getContext(), "Response Code " + response.code(), Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<List<Organization>> call, Throwable t) {
                        Toast.makeText(getContext(),"failed "+t.getMessage() , Toast.LENGTH_SHORT).show();
                        Log.e("Retrofit Call",t.getMessage());
                    }
                });



            }
        });
        return root;
    }
}