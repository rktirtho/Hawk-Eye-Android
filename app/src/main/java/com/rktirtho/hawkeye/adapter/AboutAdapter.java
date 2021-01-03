package com.rktirtho.hawkeye.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.rktirtho.hawkeye.R;
import com.rktirtho.hawkeye.model.About;

import java.util.List;

public class AboutAdapter extends ArrayAdapter<About> {
    List<About> abouts;

    //activity context
    Context context;

    //the layout resource file for the list items
    int resource;

    //constructor initializing the values
    public AboutAdapter(Context context, int resource, List<About> abouts) {
        super(context, resource, abouts);
        this.context = context;
        this.resource = resource;
        this.abouts = abouts;
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
        TextView designation = view.findViewById(R.id.tv_designation);
        TextView roll = view.findViewById(R.id.tv_roll);
        TextView regNo = view.findViewById(R.id.tv_reg);

        About about = abouts.get(position);



//        Glide.with(context)
//                .load("faculaty.getImage()")
//                .placeholder(R.drawable.prof_placeholder)
//                .error(R.drawable.prof_placeholder)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(image);

        name.setText(about.getName());
        designation.setText(about.getTitle());
        roll.setText(about.getRoll());
        regNo.setText(about.getRegNo());

        return view;
    }
}
