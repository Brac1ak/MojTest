package com.example.marcin.mojtest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherAPI {

    @GET("/data/2.5/weather")
    Call<WeatherData> getWeather(
            @Query("q") String cityName,
            @Query("APPID") String appId);

}
