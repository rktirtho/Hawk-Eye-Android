package com.rktirtho.hawkeye.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.rktirtho.hawkeye.R;
import com.rktirtho.hawkeye.model.About;
import com.rktirtho.hawkeye.model.MonitoringView;

import java.util.List;

public class MonitoringViewAdapter extends ArrayAdapter<MonitoringView> {
    List<MonitoringView> monitors;

    //activity context
    Context context;

    //the layout resource file for the list items
    int resource;

    //constructor initializing the values
    public MonitoringViewAdapter(Context context, int resource, List<MonitoringView> monitors) {
        super(context, resource, monitors);
        this.context = context;
        this.resource = resource;
        this.monitors = monitors;
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
        TextView area = view.findViewById(R.id.tv_location);
        TextView time = view.findViewById(R.id.tv_time);
        TextView access = view.findViewById(R.id.tv_access);
        LinearLayout layout = view.findViewById(R.id.container);

        MonitoringView monitor = monitors.get(position);

        area.setText(monitor.getArea());
        time.setText(
                "Time: "+monitor.getTime().getHours()+" : "+monitor.getTime().getMinutes()+" : "+monitor.getTime().getSeconds()+"  Date: "+
                monitor.getTime().getDate()+" - "+monitor.getTime().getMonth()+" - "+(1900+monitor.getTime().getYear())

        );

//        if (monitor.getPermitted()){
            access.setText("Legal "+ monitor.getPermitted());
//        }else {
//            access.setText("Illegal");
//            layout.setBackgroundColor(Color.rgb(255,0,0));
//        }

        return view;
    }
}
