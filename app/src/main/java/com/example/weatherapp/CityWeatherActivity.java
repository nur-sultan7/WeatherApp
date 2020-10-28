package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weatherapp.data.WeatherInfo;
import com.example.weatherapp.pojo.WeatherResponse;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYouListener;

import java.util.List;

public class CityWeatherActivity extends AppCompatActivity {

    private String cityInfoString;
    private WeatherResponse cityWeather;
    private MainViewModel viewModel;
    private ImageView imageViewCity;
    private TextView textViewCityName;
    private TextView textViewCityWeatherCondition;
    private TextView textViewCityTemp;
    private WeatherInfo weatherInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_weather);
        weatherInfo=new WeatherInfo();
        cityInfoString =getIntent().getStringExtra("city_info");
        viewModel= ViewModelProviders.of(this).get(MainViewModel.class);
        cityWeather=viewModel.getWeatherCityByInfo(cityInfoString);

        imageViewCity=findViewById(R.id.imageViewCityWeatherIcon);
        textViewCityName=findViewById(R.id.textViewCityName);
        textViewCityTemp=findViewById(R.id.textViewCityTemp);
        textViewCityWeatherCondition=findViewById(R.id.textViewCityCondition);
        textViewCityName.setText(cityWeather.getInfo().getTzinfo().getName());
        textViewCityTemp.setText(String.valueOf(cityWeather.getFact().getTemp()));
        textViewCityWeatherCondition.setText(weatherInfo.getConditionInRussian(cityWeather.getFact().getCondition()));
        GlideToVectorYou
                .init()
                .with(this)
                .withListener(new GlideToVectorYouListener() {
                    @Override
                    public void onLoadFailed() {
                    }
                    @Override
                    public void onResourceReady() {
                    }
                })
                //.setPlaceHolder(placeholderLoading, placeholderError)
                .load(Uri.parse(cityWeather.getWeatherIcon(cityWeather.getFact().getIcon())), imageViewCity);
   }
}
