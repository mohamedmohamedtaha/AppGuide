package com.example.manasatpc.appguide.fragment;


import android.app.ListFragment;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.manasatpc.appguide.R;
import com.example.manasatpc.appguide.adapter.Adapterobjects;
import com.example.manasatpc.appguide.model.SourceData;

import java.util.ArrayList;

import static com.example.manasatpc.appguide.DrawerLayoutActivity.toolbar;

/**
 * A simple {@link Fragment} subclass.
 */
public class OthersFragment extends ListFragment {


    public OthersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //setup the data source
        ArrayList<SourceData> sourceDataArrayList = getDataOthers();

        Adapterobjects adapterobjects = new Adapterobjects(getActivity(), sourceDataArrayList);
        setListAdapter(adapterobjects);
        return super.onCreateView(inflater, container, savedInstanceState);

    }

    //method for full data
    private ArrayList<SourceData> getDataOthers() {
        ArrayList<SourceData> sourceData = new ArrayList<SourceData>();
        sourceData.add(new SourceData(getString(R.string.others_name_one), getString(R.string.others_phone_one), getString(R.string.others_address_one), R.drawable.hotel));

        return sourceData;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolbar.setTitle(R.string.others);

    }

}
