package com.example.manasatpc.appguide.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.manasatpc.appguide.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {
    Bundle bundle;
    TextView tv_phone_mosq, tv_address_mosq;
    ImageView imageView;


    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        //bundle for bring data from Mosques Fragment
        bundle = this.getArguments();
        String phone_mosq = bundle.getString(MosquesFragment.NAME_MOSQUES);
        String address_mosq = bundle.getString(MosquesFragment.ADDRESS_MOSQUES);
        int photo_mosq = bundle.getInt(MosquesFragment.PHOTO_MOSQUES);

        tv_phone_mosq = (TextView) view.findViewById(R.id.tv_phone_mosq);
        tv_address_mosq = (TextView) view.findViewById(R.id.tv_address_mosq);
        imageView = (ImageView) view.findViewById(R.id.image_view);
        tv_phone_mosq.setText(phone_mosq);
        tv_address_mosq.setText(address_mosq);
        imageView.setImageResource(photo_mosq);

        return view;
    }

}
