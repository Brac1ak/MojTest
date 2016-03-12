package com.example.marcin.mojtest;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class FavoriteActivity extends AppCompatActivity {

    FavoriteImages favoriteImages;
    ViewPagerAdapterImage viewPagerAdapterImage;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorite_activity);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        viewPager = (ViewPager) findViewById(R.id.view_pager_favorite_activity);
        favoriteImages = new FavoriteImages(this);

        setViewPager();
    }

    private void setViewPager() {
        ArrayList<Result> results = new ArrayList<>(favoriteImages.getAllImages());

        ImageData imageData = new ImageData(results);
        viewPagerAdapterImage = new ViewPagerAdapterImage(getSupportFragmentManager(), this, imageData);
        viewPager.setAdapter(viewPagerAdapterImage);

    }

}
