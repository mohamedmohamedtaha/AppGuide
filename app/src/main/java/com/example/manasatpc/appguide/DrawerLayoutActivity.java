package com.example.manasatpc.appguide;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import com.example.manasatpc.appguide.fragment.MosquesFragment;
import com.example.manasatpc.appguide.fragment.OthersFragment;
import com.example.manasatpc.appguide.fragment.RestaurantFragment;
import com.example.manasatpc.appguide.fragment.ShoppingFragment;
import com.example.manasatpc.appguide.fragment.TopFragment;

public class DrawerLayoutActivity extends AppCompatActivity {
    /*
    private String mLanguageCodeARABIC = "ar";
    private static boolean isArabic = true;

    private String mLanguageCodeENGLISH = "en_US";
*/
    public static final String SAVE_STATE = "save_state";
    public static int titleID ;

    public static Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle ;

    //define DrawerLayout
    private DrawerLayout mDrawerLayout;
 /*   private Boolean setLanguage(){
        if (isArabic){
            return true;
        }
        else{
            return  false;
        }
        //return isArabic;
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_layout);
        //if for test Do there is data store or not
        toolbar = findViewById(R.id.toolbar);
        if (savedInstanceState != null) {
            titleID = savedInstanceState.getInt(SAVE_STATE); //restore stored value
            toolbar.setTitle(titleID);

     } else {
            Fragment fragment = new TopFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
            titleID = R.string.app_name;

        }
/*
        String getLanguage = LocaleHelper.getLanguage(this);
        if (getLanguage == "ar"){
            Toast.makeText(getApplicationContext(),"this is الانجليزية"+getLanguage,Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getApplicationContext(),"this is العربية"+getLanguage,Toast.LENGTH_LONG).show();
        }*/

        //for set Toolbar and put it ic_menu
       // toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                // set item as selected to persist highlight
                item.setCheckable(true);
                //close drawer when item is tapped
                mDrawerLayout.closeDrawers();
                selectItem(item);

                return true;
            }
        });
    }
    //method for open Fragment depending on item Clicked
    private void selectItem(MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.nav_Mosques:
                fragment = new MosquesFragment();
                titleID = R.string.mosques;
                break;
            case R.id.nav_restaurants:
                fragment = new RestaurantFragment();
                titleID = R.string.restaurants;

                break;
            case R.id.nav_shopping:
                fragment = new ShoppingFragment();
                titleID = R.string.shopping;
                break;
            case R.id.nav_others:
                fragment = new OthersFragment();
                titleID = R.string.others;
                break;

            default:
                fragment = new TopFragment();
                titleID = R.string.app_name;

        }
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        ft.commit();
        toolbar.setTitle(titleID);

        mDrawerLayout.closeDrawers();

    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.language,menu);
        return true;
    }
*/



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
/*
                //for change Language
            case R.id.ab_language:
                if (setLanguage()){
                    LocaleHelper.setLocale(DrawerLayoutActivity.this,mLanguageCodeARABIC);
                    isArabic = false;
                    recreate();
                }else {
                    LocaleHelper.setLocale(DrawerLayoutActivity.this,mLanguageCodeENGLISH);
                    isArabic = true;
                    recreate();
                }

                break;*/
        }
        return true;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SAVE_STATE, titleID);


    }
 }