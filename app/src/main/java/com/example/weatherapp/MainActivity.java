package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.weatherapp.adapters.MainWeatherAdapter;
import com.example.weatherapp.data.City;
import com.example.weatherapp.pojo.WeatherResponse;

import java.util.List;

public class MainActivity extends AppCompatActivity {

   private MainWeatherAdapter mainWeatherAdapter;
   private RecyclerView recyclerView;
   private MainViewModel viewModel;
   private boolean isToday;
   private Switch switchSort;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        switchSort=findViewById(R.id.switchSort);
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainWeatherAdapter=new MainWeatherAdapter(this);
        recyclerView = findViewById(R.id.recyclerViewCities);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(mainWeatherAdapter);
        isToday=true;
//        viewModel.loadData();
        viewModel.getDataWeatherResponse().observe(this, new Observer<List<WeatherResponse>>() {
                    @Override
                    public void onChanged(List<WeatherResponse> weatherResponses) {
                        mainWeatherAdapter.setWeatherResponseList(weatherResponses,isToday);
                    }
                }
        );
        switchSort.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    mainWeatherAdapter.setToday(false);
                }
                else
                {
                    mainWeatherAdapter.setToday(true);
                }
            }
        });
        loadData();
    }
    public  void loadData()
    {
        viewModel.loadData(City.getRussianCitiesList());
    }
}
