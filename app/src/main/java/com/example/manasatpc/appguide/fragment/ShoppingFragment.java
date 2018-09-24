package com.example.manasatpc.appguide.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.app.ListFragment;
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
public class ShoppingFragment extends ListFragment {


    public ShoppingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //setup the data source
        ArrayList<SourceData> sourceDataArrayList = getDataShopping();

        Adapterobjects adapterobjects = new Adapterobjects(getActivity(), sourceDataArrayList);
        setListAdapter(adapterobjects);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    //method for full data
    private ArrayList<SourceData> getDataShopping() {
        ArrayList<SourceData> sourceData = new ArrayList<SourceData>();
        sourceData.add(new SourceData(getString(R.string.shopping_name_one),
                getString(R.string.mosque_description_main_one), getString(R.string.shopping_address_one)
                , R.drawable.kanelkalely, 0));
        sourceData.add(new SourceData(getString(R.string.shopping_name_two)
                , getString(R.string.mosque_description_main_two), getString(R.string.shopping_address_two), R.drawable.elmoez, 0));
        sourceData.add(new SourceData(getString(R.string.shopping_name_three),
                getString(R.string.mosque_description_main_two),
                getString(R.string.shopping_address_three), R.drawable.elsehemy, 0));
        sourceData.add(new SourceData(getString(R.string.shopping_name_four)
                , getString(R.string.mosque_description_main_two), getString(R.string.shopping_address_four)
                , R.drawable.wkaletelgory, 0));


        return sourceData;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolbar.setTitle(R.string.shopping);

    }

}


