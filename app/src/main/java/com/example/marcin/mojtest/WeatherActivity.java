package com.example.marcin.mojtest;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherActivity extends AppCompatActivity implements Callback<WeatherData> {

    WeatherRestAdapter weatherRestAdapter;
    WeatherData weatherData;
    WeatherFragment weatherFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_activity);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        weatherFragment = (WeatherFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_weather_activity);

        weatherRestAdapter = new WeatherRestAdapter();
        Call<WeatherData> data = weatherRestAdapter.getWeatherApi("bialystok");
        data.enqueue(this);

    }

    @Override
    public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
        weatherData = response.body();
        weatherFragment.setWeatherData(weatherData);
    }

    @Override
    public void onFailure(Call<WeatherData> call, Throwable t) {
    }
}
