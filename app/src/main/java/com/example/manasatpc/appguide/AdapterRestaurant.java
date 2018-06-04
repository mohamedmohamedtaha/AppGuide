package com.example.manasatpc.appguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ManasatPC on 26/05/18.
 */

public class AdapterRestaurant extends BaseAdapter {
    //context
    private Context mContext;
    //data source of the list adapter
    private ArrayList<SourceData> sourceData;

    //public constructor
    public AdapterRestaurant(Context context, ArrayList<SourceData> sourceData) {
        this.mContext = context;
        this.sourceData = sourceData;
    }

    @Override
    public int getCount() {
        //return total of items in the list
        return sourceData.size();
    }

    @Override
    public Object getItem(int i) {
        //return list item at the specified position
        return sourceData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // inflate the layout for each list row
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.custom_restaurant, viewGroup, false);
        }
        //get current item to be displayed
        SourceData currentSourceData = (SourceData) getItem(i);

        //get the TextView for restaurant name , restaurant phone , restaurant address and photos
        TextView tv_name_restaurant, tv_address_restaurant, tv_phone_restaurant;
        ImageView iv_show_image;
        tv_name_restaurant = (TextView) view.findViewById(R.id.tv_name_restaurant);
        tv_address_restaurant = (TextView) view.findViewById(R.id.tv_address_restaurant);
        tv_phone_restaurant = (TextView) view.findViewById(R.id.tv_phone_restaurant);
        iv_show_image = (ImageView) view.findViewById(R.id.iv_show_image);

        //sets the text for restaurant name ,  restaurant phone , restaurant address and photos
        tv_name_restaurant.setText(currentSourceData.getName_restaurant());
        tv_address_restaurant.setText(currentSourceData.getAddress_restaurant());
        tv_phone_restaurant.setText(currentSourceData.getphone_restaurant());
        //for check Do there phone or no
        if (currentSourceData.getCheck_drawable() == 0) {
            tv_phone_restaurant.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            tv_phone_restaurant.setPaddingRelative(32, 0, 0, 0);
        } else {
            tv_phone_restaurant.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_phone, 0, 0, 0);

        }

        iv_show_image.setImageResource(currentSourceData.getImage_show());

        //returns the view for the current row
        return view;
    }
}






















