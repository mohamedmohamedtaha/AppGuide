package com.example.manasatpc.appguide.fragment;


import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import android.app.Fragment;
import android.widget.ListView;

import com.example.manasatpc.appguide.R;
import com.example.manasatpc.appguide.adapter.Adapterobjects;
import com.example.manasatpc.appguide.model.SourceData;

import static com.example.manasatpc.appguide.DrawerLayoutActivity.toolbar;

/**
 * A simple {@link Fragment} subclass.
 */
public class MosquesFragment extends ListFragment {
    //variables static for bundle values
    public static final String NAME_MOSQUES = "name";
    public static final String ADDRESS_MOSQUES = "address";
    public static final String PHOTO_MOSQUES = "photo";

    ArrayList<SourceData> sourceData = null;

    public MosquesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //setup the data source
        ArrayList<SourceData> sourceDataArrayList = getDataMosques();

        Adapterobjects adapterobjects = new Adapterobjects(getActivity(), sourceDataArrayList);
        setListAdapter(adapterobjects);


        return super.onCreateView(inflater, container, savedInstanceState);
    }
    //method for full data

    private ArrayList<SourceData> getDataMosques() {
        sourceData = new ArrayList<SourceData>();
        sourceData.add(new SourceData(getString(R.string.mosque_name_one),
                getString(R.string.mosque_description_main_one), getString(R.string.mosque_address_one)
                , R.drawable.elhosen, 0));
        sourceData.add(new SourceData(getString(R.string.mosque_name_two),
                getString(R.string.mosque_description_main_two)
                , getString(R.string.mosque_address_two), R.drawable.elazhar, 0));


        return sourceData;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        //when click on item
        Bundle bundle = new Bundle();
        //switch for test click user
        switch (position) {
            case 0:
                bundle.putString(NAME_MOSQUES, getString(R.string.mosque_name_one));
                bundle.putString(ADDRESS_MOSQUES, getString(R.string.mosque_description_detail_one));
                bundle.putInt(PHOTO_MOSQUES, R.drawable.elhosen);
                break;
            case 1:
                bundle.putString(NAME_MOSQUES, getString(R.string.mosque_name_two));
                bundle.putString(ADDRESS_MOSQUES, getString(R.string.mosque_description_detail_two));
                bundle.putInt(PHOTO_MOSQUES, R.drawable.elazhar);
                break;
        }
        DetailFragment startFragment = new DetailFragment();
        startFragment.setArguments(bundle);

        getActivity().getFragmentManager().beginTransaction().replace(R.id.content_frame, startFragment,null)
                .addToBackStack(null).commit();


    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolbar.setTitle(R.string.mosques);

    }

}