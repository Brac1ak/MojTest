package com.example.marcin.mojtest;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImageRestAdapter {

    protected Retrofit restAdapter;
    protected ImageAPI imageAPI;
    private static final String BASE_URL="https://api.themoviedb.org/";
    private static final String API_KEY = "4cb447f8dfdee9e34b54d059e6fb1b33";

    public ImageRestAdapter() {

        restAdapter = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        imageAPI = restAdapter.create(ImageAPI.class);

    }

    public Call<ImageData> getImageApi(){
        return imageAPI.getImages(API_KEY);
    }

}
