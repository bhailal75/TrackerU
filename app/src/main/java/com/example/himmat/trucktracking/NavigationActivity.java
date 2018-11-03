package com.example.himmat.trucktracking;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.himmat.trucktracking.baseclass.BaseAppCompactActivity;
import com.example.himmat.trucktracking.container.BaseContainer;
import com.example.himmat.trucktracking.container.HomeContainer;
import com.example.himmat.trucktracking.databinding.ActivityNavigationBinding;
import com.example.himmat.trucktracking.model.ImeiListResp;
import com.example.himmat.trucktracking.retrofit.APICall;
import com.example.himmat.trucktracking.retrofit.APICallback;
import com.example.himmat.trucktracking.retrofit.OnApiResponseListner;

import retrofit2.Call;

public class NavigationActivity extends BaseAppCompactActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnApiResponseListner {

    private ActivityNavigationBinding mBinding;
    private static String currentFragment;
    private Call<?> callImei;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

//        callImei = ((TruckApp)getApplication()).getApiTask().getAllImei(
//                new APICallback(this, APICall.LOGIN_CODE,this));
//
//

        currentFragment = HomeContainer.class.getSimpleName();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, new HomeContainer(), HomeContainer.class.getSimpleName());
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            boolean isPop = false;
            if (currentFragment.equals(HomeContainer.class.getSimpleName())) {
                isPop = ((BaseContainer) getSupportFragmentManager().findFragmentByTag(HomeContainer.class.getSimpleName())).popFragment();
            }
            if (!isPop) {
                super.onBackPressed();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;
        String title = null;

        switch (id){
            case R.id.nav_home:
                title = "Home";
                currentFragment = HomeContainer.class.getSimpleName();
                fragment = new HomeContainer();
                break;
            case R.id.nav_notification:
                break;
            case R.id.nav_setting:
                break;
            case R.id.nav_logout:
                break;
        }

        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment, fragment.getClass().getSimpleName());
            ft.commit();
            getSupportActionBar().setTitle(title);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onResponseComplete(Object clsGson, int requestCode) {
        if (requestCode == APICall.LOGIN_CODE){
            if (clsGson instanceof ImeiListResp){
                ImeiListResp imeiListResp = (ImeiListResp) clsGson;
                if (imeiListResp.getName() != null);
            }
        }
    }

    @Override
    public void onResponseError(Object errorMessage, int requestCode) {

    }
}
