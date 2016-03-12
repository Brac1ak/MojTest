package com.example.marcin.mojtest;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        toolbar.setTitle(getTitle());
        navigationView = (NavigationView) findViewById(R.id.navigation_view_main);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_main);

        setNavigationDrawer();

    }

    private void setNavigationDrawer() {

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.drawer_open, R.string.drawer_close);

        drawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int idItem = item.getItemId();

        switch (idItem){

            case R.id.navigation_view_main_opis_aplikacji:
                startActivity(new Intent(this, WebViewActivity.class));
                drawerLayout.closeDrawers();
                break;

            case R.id.navigation_view_main_pogoda:
                startActivity(new Intent(this, WeatherActivity.class));
                drawerLayout.closeDrawers();
                break;

            case R.id.navigation_view_main_zdjecia:
                startActivity(new Intent(this, ImageActivity.class));
                drawerLayout.closeDrawers();
                break;

            case R.id.navigation_view_main_ulubione:
                startActivity(new Intent(this, FavoriteActivity.class));
                drawerLayout.closeDrawers();
                break;


        }

        return false;
    }
}
