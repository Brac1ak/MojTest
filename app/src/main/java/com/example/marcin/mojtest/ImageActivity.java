package com.example.marcin.mojtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ImageActivity extends AppCompatActivity implements Callback<ImageData> {

    ImageRestAdapter imageRestAdapter;
    ImageData imageData;
    ImageFragment imageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_activity);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        imageFragment = (ImageFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_image_activity);

        imageRestAdapter = new ImageRestAdapter();
        Call<ImageData> data = imageRestAdapter.getImageApi();
        data.enqueue(this);

    }

    @Override
    public void onResponse(Call<ImageData> call, Response<ImageData> response) {
        imageData = response.body();
        imageFragment.setImageData(imageData);
    }

    @Override
    public void onFailure(Call<ImageData> call, Throwable t) {

    }
}
