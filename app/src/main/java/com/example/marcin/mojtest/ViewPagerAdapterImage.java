package com.example.marcin.mojtest;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class ViewPagerAdapterImage extends FragmentStatePagerAdapter {


    ImageData imageData;
    Context context;

    public ViewPagerAdapterImage(FragmentManager fm, Context context, ImageData imageData) {
        super(fm);
        this.context = context;
        this.imageData = imageData;
    }

    @Override
    public Fragment getItem(int position) {
        return ImageFragmentPagerAdapter.newInstance(position, imageData);
    }

    @Override
    public int getCount() {
        return imageData.results.size();
    }

}
