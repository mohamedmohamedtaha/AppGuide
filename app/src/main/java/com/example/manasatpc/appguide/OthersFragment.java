package com.example.manasatpc.appguide;


import android.app.ListFragment;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

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
        ArrayList<SourceData> sourceDataArrayList = getDataRestaurant();

        AdapterRestaurant adapterRestaurant = new AdapterRestaurant(getActivity(), sourceDataArrayList);
        setListAdapter(adapterRestaurant);
        return super.onCreateView(inflater, container, savedInstanceState);

    }

    //method for full data
    private ArrayList<SourceData> getDataRestaurant() {
        ArrayList<SourceData> sourceData = new ArrayList<SourceData>();
        sourceData.add(new SourceData(getString(R.string.others_name_one), getString(R.string.others_phone_one), getString(R.string.others_address_one), R.drawable.hotel));

        return sourceData;
    }

}
