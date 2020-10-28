package com.example.weatherapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
   private boolean isRussianCities;

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        menu.setGroupVisible(R.id.menu_european_cities_group,false);
        menu.setGroupVisible(R.id.menu_russian_counties_group,true);

        final MenuItem rc = menu.findItem(R.id.menu_russian_counties);
//        rc.getSubMenu().getItem().setVisible(false);
        final MenuItem ec = menu.findItem(R.id.menu_european_cities);
  //      ec.getSubMenu().getItem().setVisible(true);
        rc.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                menu.setGroupVisible(R.id.menu_european_cities_group,true);
                menu.setGroupVisible(R.id.menu_russian_counties_group,false);
                isRussianCities=false;
                switchSort.setChecked(false);
                loadData(false);
                return false;
            }
        });
        ec.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                menu.setGroupVisible(R.id.menu_european_cities_group,false);
                menu.setGroupVisible(R.id.menu_russian_counties_group,true);
                isRussianCities=true;
                switchSort.setChecked(false);
                loadData(true);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isRussianCities=true;
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
        mainWeatherAdapter.setOnItemClickListener(new MainWeatherAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(MainActivity.this, CityWeatherActivity.class);
                intent.putExtra("city_index",position);
                startActivity(intent);
            }
        });
        loadData(isRussianCities);

    }
    public  void loadData(boolean isRussianCities)
    {
        if (isRussianCities)
        viewModel.loadData(City.getRussianCitiesList());
        else
            viewModel.loadData(City.getEuropeanCitiesList());
    }
}
