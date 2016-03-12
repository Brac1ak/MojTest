package com.example.marcin.mojtest;


import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherRestAdapter {

    protected Retrofit restAdapter;
    protected WeatherAPI weatherAPI;
    public static final String BASE_IMAGE_URL = "http://openweathermap.org/img/w/";
    private static final String WEATHER_URL="http://api.openweathermap.org";
    private static final String OPEN_WEATHER_API = "d0439fc2ca4e39db39395cf2ab129513";

    public WeatherRestAdapter() {

        restAdapter = new Retrofit.Builder().baseUrl(WEATHER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        weatherAPI = restAdapter.create(WeatherAPI.class);

    }

    public Call<WeatherData> getWeatherApi(String city){
        return weatherAPI.getWeather(city, OPEN_WEATHER_API);
    }

}
