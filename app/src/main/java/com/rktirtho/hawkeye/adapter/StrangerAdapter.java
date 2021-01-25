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

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.rktirtho.hawkeye.R;
import com.rktirtho.hawkeye.client.RetrofitClient;
import com.rktirtho.hawkeye.model.About;
import com.rktirtho.hawkeye.model.Stranger;

import java.util.List;

public class StrangerAdapter extends ArrayAdapter<Stranger> {
    List<Stranger> strangers;

    //activity context
    Context context;

    //the layout resource file for the list items
    int resource;

    //constructor initializing the values
    public StrangerAdapter(Context context, int resource, List<Stranger> strangers) {
        super(context, resource, strangers);
        this.context = context;
        this.resource = resource;
        this.strangers = strangers;
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

        ImageView imageView = view.findViewById(R.id.iv_image);
        TextView title = view.findViewById(R.id.tv_title);
        TextView visited = view.findViewById(R.id.tv_visited);
        TextView time = view.findViewById(R.id.tv_first_in);

        Stranger stranger = strangers.get(position);

        Glide.with(context)
                .load(RetrofitClient.BASE_URL+"images/"+stranger.getImage()+".jpg")
                .placeholder(R.drawable.logo)
                .error(R.drawable.logo)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);

        title.setText(stranger.getImage());
        visited.setText("Visited: "+stranger.getVisited());
        time.setText("First In: "
                +stranger.getTime().getDay()+"."
                +(stranger.getTime().getMonth()+1)+"."
                +(stranger.getTime().getYear()+1900));

        return view;
    }
}
