package com.example.manasatpc.appguide;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

public class DrawerLayoutActivity extends AppCompatActivity {
    private String mLanguageCodeARABIC = "ar";
    private static boolean isArabic = true;

    private String mLanguageCodeENGLISH = "en_US";

    public static final String SAVE_STATE = "save_state";
    String[] titles;
    Toolbar toolbar;
    NavigationView navigationView;

    CharSequence charSequence = null;
    //define DrawerLayout
    private DrawerLayout mDrawerLayout;
    private Boolean setLanguage(){
        if (isArabic){
            return true;
        }
        else{
            return  false;
        }
        //return isArabic;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_layout);
        //if for test Do there is data store or not
        if (savedInstanceState != null) {
            charSequence = savedInstanceState.getCharSequence(SAVE_STATE);
            setTitle(charSequence);
        } else {
            getTitle();
            Fragment fragment = new TopFragment();

            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);

            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();

        }


        titles = getResources().getStringArray(R.array.titles_pages);


        //for set Toolbar and put it ic_menu
        toolbar = findViewById(R.id.toolbar);
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
                break;
            case R.id.nav_restaurants:
                fragment = new RestaurantFragment();

                break;
            case R.id.nav_shopping:
                fragment = new ShoppingFragment();

                break;
            case R.id.nav_others:
                fragment = new OthersFragment();
                break;

            default:
                fragment = new TopFragment();
        }
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment);

        ft.addToBackStack(null);
        setTitle(item.getTitle());
        charSequence = item.getTitle();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();

        mDrawerLayout.closeDrawers();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.language,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;

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

                break;
        }
        return true;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.getCharSequence(SAVE_STATE, charSequence);
    }
}