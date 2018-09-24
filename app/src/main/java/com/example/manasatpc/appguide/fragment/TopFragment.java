package com.example.manasatpc.appguide.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.example.manasatpc.appguide.R;

import static com.example.manasatpc.appguide.DrawerLayoutActivity.titleID;
import static com.example.manasatpc.appguide.DrawerLayoutActivity.toolbar;


public class TopFragment extends Fragment {
 //   Toolbar toolbar ;


    public TopFragment() {
        // Required empty public constructor
    }


        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_top, container, false);
       // toolbar = (Toolbar)view.findViewById(R.id.toolbar);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
            toolbar.setTitle(R.string.app_name);

    }
}



