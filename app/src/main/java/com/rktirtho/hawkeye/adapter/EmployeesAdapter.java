package com.rktirtho.hawkeye.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.rktirtho.hawkeye.R;
import com.rktirtho.hawkeye.client.RetrofitClient;
import com.rktirtho.hawkeye.model.Employees;
import com.rktirtho.hawkeye.model.Organization;

import java.util.List;

public class EmployeesAdapter extends ArrayAdapter<Employees> {
    List<Employees> employees;

    //activity context
    Context context;

    //the layout resource file for the list items
    int resource;

    //constructor initializing the values
    public EmployeesAdapter(Context context, int resource, List<Employees> employees) {
        super(context, resource, employees);
        this.context = context;
        this.resource = resource;
        this.employees = employees;
    }

    //this will return the ListView Item as a View
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //we need to get the view of the xml for our list item
        //And for this we need a layoutinflater
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        //getting the view
        View view = layoutInflater.inflate(resource, null, false);

        //getting the view elements of the list from the view
        TextView name = view.findViewById(R.id.tv_name);
        TextView id = view.findViewById(R.id.tv_emp_id);
        TextView office = view.findViewById(R.id.tv_organization);

        Employees employee = employees.get(position);

        ImageView image = view.findViewById(R.id.tv_image);



        Glide.with(context)
                .load(RetrofitClient.BASE_URL+"images/"+employee.getImageId()+".jpg")
                .placeholder(R.drawable.logo)
                .error(R.drawable.logo)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(image);

        Log.e("[ Images ]", RetrofitClient.BASE_URL+"/images"+employee.getImageId()+".jpg");

        name.setText(employee.getName());
        id.setText("ID: "+employee.getId());
        office.setText(employee.getOrgName());

        return view;
    }

}
