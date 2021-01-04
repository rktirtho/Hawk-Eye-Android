package com.rktirtho.hawkeye.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.rktirtho.hawkeye.R;
import com.rktirtho.hawkeye.model.About;
import com.rktirtho.hawkeye.model.Organization;

import java.util.List;

public class OrganizationAdapter extends ArrayAdapter<Organization> {
    List<Organization> organizations;

    //activity context
    Context context;

    //the layout resource file for the list items
    int resource;

    //constructor initializing the values
    public OrganizationAdapter(Context context, int resource, List<Organization> organizations) {
        super(context, resource, organizations);
        this.context = context;
        this.resource = resource;
        this.organizations = organizations;
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
        TextView owner = view.findViewById(R.id.tv_owner);
        TextView address = view.findViewById(R.id.tv_address);
        TextView regDate = view.findViewById(R.id.tv_reg_date);

        Organization organization = organizations.get(position);



//        Glide.with(context)
//                .load("faculaty.getImage()")
//                .placeholder(R.drawable.prof_placeholder)
//                .error(R.drawable.prof_placeholder)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(image);

        name.setText(organization.getName());
        address.setText(organization.getAddress());
        owner.setText(organization.getWoner());
        regDate.setText(organization.getRegDate());

        return view;
    }
}
