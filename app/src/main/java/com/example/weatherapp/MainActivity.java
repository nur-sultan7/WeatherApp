package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.weatherapp.adapters.MainWeatherAdapter;
import com.example.weatherapp.pojo.WeatherResponse;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    MainWeatherAdapter mainWeatherAdapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainWeatherAdapter=new MainWeatherAdapter(this);
        recyclerView = findViewById(R.id.recyclerViewCities);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(mainWeatherAdapter);
//        viewModel.loadData();
        viewModel.getDataWeatherResponse().observe(this, new Observer<WeatherResponse>() {
            @Override
            public void onChanged(WeatherResponse weatherResponses) {
                mainWeatherAdapter.addItemToWeatherResponseList(weatherResponses);
            }
        });
        viewModel.loadData();

    }
}
