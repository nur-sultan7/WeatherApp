package com.example.weatherapp.city_info;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager2.widget.ViewPager2;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.weatherapp.MainViewModel;
import com.example.weatherapp.R;
import com.example.weatherapp.city_info.fragmets.TodayWeatherInfoFragment;
import com.example.weatherapp.city_info.fragmets.TomorrowWeatherInfoFragment;
import com.example.weatherapp.data.WeatherInfo;
import com.example.weatherapp.pojo.WeatherResponse;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYouListener;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
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
    private ViewPager2 viewPager2;
    private CityWeatherInfoViewPagerAdapter viewPagerAdapter;
    private List<Fragment> fragmentList;
    private TabLayout tabLayout;
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
        viewPager2=findViewById(R.id.viewPagerCityWeatherInfo);
        tabLayout=findViewById(R.id.tabLayoutCityWeatherInfo);

        fragmentList=new ArrayList<>();
        fragmentList.add(TodayWeatherInfoFragment.newInstance(cityInfoString));
        fragmentList.add(TomorrowWeatherInfoFragment.newInstance(cityInfoString));
        viewPagerAdapter=new CityWeatherInfoViewPagerAdapter(getSupportFragmentManager(),getLifecycle(),fragmentList);
        viewPager2.setAdapter(viewPagerAdapter);
        new TabLayoutMediator(tabLayout, viewPager2, true, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position)
                {
                    case 0:
                        tab.setText("Сегодня");
                        break;
                    case 1:
                        tab.setText("Завтра");
                        break;
                }

            }
        }).attach();
   }
}
