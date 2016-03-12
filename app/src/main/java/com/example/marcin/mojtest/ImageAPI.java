package com.example.marcin.mojtest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ImageAPI {

    @GET("3/movie/popular")
    Call<ImageData> getImages(
            @Query("api_key") String appId);

}
