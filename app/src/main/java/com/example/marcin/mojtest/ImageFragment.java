package com.example.marcin.mojtest;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ImageFragment extends Fragment {

    Context context;
    ImageData imageData;

    ViewPagerAdapterImage viewPagerAdapterImage;
    ViewPager viewPager;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.image_fragment, container, false);

        viewPager = (ViewPager) view.findViewById(R.id.view_pager_image_fragment);

        return view;
    }

    public void setImageData(ImageData imageData){
        this.imageData = imageData;
        setViewPager();
    }

    private void setViewPager(){
        viewPagerAdapterImage = new ViewPagerAdapterImage(getActivity().getSupportFragmentManager(), context, imageData);
        viewPager.setAdapter(viewPagerAdapterImage);
    }

}
