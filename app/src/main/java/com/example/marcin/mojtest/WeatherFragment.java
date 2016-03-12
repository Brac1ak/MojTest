package com.example.marcin.mojtest;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class WeatherFragment extends Fragment implements Callback {

    Context context;
    ProgressBar progressBar;
    ImageView image;
    TextView cityTitleTextView, temperatureTextView, weatherDescriptionTextView, temperatureMaxTextView,
            temperatureMinTextView, pressureTextView, humidityTextView, windTextView, cloudsTextView,
            weatherTodayTextView, temperatureTextTextView, temperatureMaxTextTextView,
            temperatureMinTextTextView, pressureTextTextView, humidityTextTextView, windTextTextView,
            cloudsTextTextView;

    WeatherData weathers;

    boolean downloadImage = false;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.weather_fragment, container, false);

        weatherTodayTextView = (TextView) view.findViewById(R.id.text_view_pogoda_na_dzis_text_weather_fragment);
        cityTitleTextView = (TextView) view.findViewById(R.id.text_view_city_name_weather_activity);
        temperatureTextView = (TextView) view.findViewById(R.id.text_view_temperatura_weather_fragment);
        temperatureMaxTextView = (TextView) view.findViewById(R.id.text_view_temperatura_max_weather_fragment);
        temperatureMinTextView = (TextView) view.findViewById(R.id.text_view_temperatura_min_weather_fragment);
        pressureTextView = (TextView) view.findViewById(R.id.text_view_cisnienie_weather_fragment);
        humidityTextView = (TextView) view.findViewById(R.id.text_view_wilgotnosc_weather_fragment);
        windTextView = (TextView) view.findViewById(R.id.text_view_wiatr_weather_fragment);
        progressBar = (ProgressBar) view.findViewById(R.id.progress_bar_weather_fragment);
        image = (ImageView) view.findViewById(R.id.image_view_weather_image_weather_fragment);
        cloudsTextView = (TextView) view.findViewById(R.id.text_view_zachmurzenie_weather_fragment);
        weatherDescriptionTextView = (TextView) view.findViewById(R.id.text_view_opis_pogody_weather_fragment);

        temperatureTextTextView = (TextView) view.findViewById(R.id.text_view_temperatura_text_weather_fragment);
        temperatureMaxTextTextView = (TextView) view.findViewById(R.id.text_view_temperatura_max_text_weather_fragment);
        temperatureMinTextTextView = (TextView) view.findViewById(R.id.text_view_temperatura_min_text_weather_fragment);
        pressureTextTextView = (TextView) view.findViewById(R.id.text_view_cisnienie_text_weather_fragment);
        humidityTextTextView = (TextView) view.findViewById(R.id.text_view_wilgotnosc_text_weather_fragment);
        windTextTextView = (TextView) view.findViewById(R.id.text_view_wiatr_text_weather_fragment);
        cloudsTextTextView = (TextView) view.findViewById(R.id.text_view_zachmurzenie_text_weather_fragment);

        setVisibleProgressBar();

        return view;
    }

    public void setWeatherData(WeatherData weatherList){
        this.weathers = weatherList;
        setData();
    }

    private void setData(){

        Double temp = (weathers.getMain().getTemp() - 275.15D);
        Double tempMax = (weathers.getMain().getTemp_max() - 275.15D);
        Double tempMin = (weathers.getMain().getTemp_min() - 275.15D);
        Double pressure = weathers.getMain().getPressure();
        Double wind = weathers.getWinds().getSpeed();

        weatherDescriptionTextView.setText(weathers.getWeather().get(0).getDescription().toUpperCase());
        cityTitleTextView.setText(weathers.getName());
        temperatureTextView.setText(String.valueOf(temp.intValue()) + (char) 0x00B0);
        temperatureMaxTextView.setText(String.valueOf(tempMax.intValue()) + (char) 0x00B0);
        temperatureMinTextView.setText(String.valueOf(tempMin.intValue()) + (char) 0x00B0);
        pressureTextView.setText(String.valueOf(pressure.intValue()) + " hPa");
        humidityTextView.setText(String.valueOf(weathers.getMain().getHumidity() + " %"));
        windTextView.setText(String.valueOf(wind.intValue() + " km/h"));
        cloudsTextView.setText(String.valueOf(weathers.getClouds().getClouds() + " %"));
        Picasso.with(context).load(WeatherRestAdapter.BASE_IMAGE_URL + weathers.getWeather().get(0).getIcon() + ".png")
                .into(image, this);


    }

    private void setVisibleProgressBar() {

        if (downloadImage){
            progressBar.setVisibility(View.GONE);
            cloudsTextView.setVisibility(View.VISIBLE);
            weatherTodayTextView.setVisibility(View.VISIBLE);
            weatherDescriptionTextView.setVisibility(View.VISIBLE);
            temperatureTextTextView.setVisibility(View.VISIBLE);
            temperatureMaxTextTextView.setVisibility(View.VISIBLE);
            temperatureMinTextTextView.setVisibility(View.VISIBLE);
            pressureTextTextView.setVisibility(View.VISIBLE);
            humidityTextTextView.setVisibility(View.VISIBLE);
            windTextTextView.setVisibility(View.VISIBLE);
            cloudsTextTextView.setVisibility(View.VISIBLE);
            cityTitleTextView.setVisibility(View.VISIBLE);
            temperatureTextView.setVisibility(View.VISIBLE);
            temperatureMaxTextView.setVisibility(View.VISIBLE);
            temperatureMinTextView.setVisibility(View.VISIBLE);
            pressureTextView.setVisibility(View.VISIBLE);
            humidityTextView.setVisibility(View.VISIBLE);
            windTextView.setVisibility(View.VISIBLE);
            image.setVisibility(View.VISIBLE);
        }else {
            progressBar.setVisibility(View.VISIBLE);
            cloudsTextView.setVisibility(View.GONE);
            weatherTodayTextView.setVisibility(View.GONE);
            weatherDescriptionTextView.setVisibility(View.GONE);
            temperatureTextTextView.setVisibility(View.GONE);
            temperatureMaxTextTextView.setVisibility(View.GONE);
            temperatureMinTextTextView.setVisibility(View.GONE);
            pressureTextTextView.setVisibility(View.GONE);
            humidityTextTextView.setVisibility(View.GONE);
            windTextTextView.setVisibility(View.GONE);
            cloudsTextTextView.setVisibility(View.GONE);
            cityTitleTextView.setVisibility(View.GONE);
            temperatureTextView.setVisibility(View.GONE);
            temperatureMaxTextView.setVisibility(View.GONE);
            temperatureMinTextView.setVisibility(View.GONE);
            pressureTextView.setVisibility(View.GONE);
            humidityTextView.setVisibility(View.GONE);
            windTextView.setVisibility(View.GONE);
            image.setVisibility(View.GONE);
        }
    }

    @Override
    public void onSuccess() {
        downloadImage = true;
        setVisibleProgressBar();
    }

    @Override
    public void onError() {

    }
}
