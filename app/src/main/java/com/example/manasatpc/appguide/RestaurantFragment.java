package com.example.manasatpc.appguide;


import android.os.Bundle;
import android.app.Fragment;
import android.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RestaurantFragment extends ListFragment {


    public RestaurantFragment() {
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
        sourceData.add(new SourceData(getString(R.string.name_one), getString(R.string.phone_one), getString(R.string.address_one), R.drawable.hart_abo_basem));
        sourceData.add(new SourceData(getString(R.string.name_two), getString(R.string.phone_two), getString(R.string.address_two), R.drawable.haty_elamal));
        sourceData.add(new SourceData(getString(R.string.name_three), getString(R.string.phone_three), getString(R.string.address_three), R.drawable.haty_eldhan));
        sourceData.add(new SourceData(getString(R.string.name_four), getString(R.string.phone_four), getString(R.string.address_four), R.drawable.elzoghby));
        sourceData.add(new SourceData(getString(R.string.name_five), getString(R.string.phone_five), getString(R.string.address_five), R.drawable.obra));
        sourceData.add(new SourceData(getString(R.string.name_six), getString(R.string.phone_six), getString(R.string.address_six), R.drawable.elmalky));
        sourceData.add(new SourceData(getString(R.string.name_seven), getString(R.string.phone_seven), getString(R.string.address_seven), R.drawable.farahat));
        sourceData.add(new SourceData(getString(R.string.name_nine), getString(R.string.phone_nine), getString(R.string.address_nine), R.drawable.aklbety));
        sourceData.add(new SourceData(getString(R.string.name_ten), getString(R.string.phone_ten), getString(R.string.address_ten), R.drawable.fot));

        return sourceData;
    }

}
