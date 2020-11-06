package com.example.weatherapp.city_info.fragmets;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.weatherapp.MainViewModel;
import com.example.weatherapp.R;
import com.example.weatherapp.city_info.adapters.ThreeDaysWIAdapter;
import com.example.weatherapp.city_info.data.Day;
import com.example.weatherapp.data.WeatherInfo;
import com.example.weatherapp.pojo.WeatherResponse;

import java.util.ArrayList;
import java.util.List;


public class ThreeDaysWIFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;
    private ThreeDaysWIAdapter threeDaysWIAdapter;
    private MainViewModel viewModel;
    private WeatherResponse weatherResponse;

    public ThreeDaysWIFragment() {
        // Required empty public constructor
    }

    public static ThreeDaysWIFragment newInstance(String param1) {
        ThreeDaysWIFragment fragment = new ThreeDaysWIFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
    //    args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
        viewModel= ViewModelProviders.of(this).get(MainViewModel.class);
        weatherResponse=viewModel.getWeatherCityByInfo(mParam1);
        List<Day> dayList=new ArrayList<>();
        Time currentTime = new Time(Time.getCurrentTimezone());
        currentTime.setToNow();

        dayList.add(new Day(WeatherInfo.getDayOfWeek(currentTime.weekDay),
                weatherResponse.getForecasts().get(0).getDate(),
                weatherResponse.getForecasts().get(0).getParts().getDayShort()));
        dayList.add(new Day(WeatherInfo.getDayOfWeek(currentTime.weekDay==6?0:currentTime.weekDay+1),
                weatherResponse.getForecasts().get(1).getDate(),
                weatherResponse.getForecasts().get(1).getParts().getDayShort()));
        threeDaysWIAdapter=new ThreeDaysWIAdapter(dayList);
        dayList.add(new Day(WeatherInfo.getDayOfWeek(currentTime.weekDay>=5?currentTime.weekDay-5:currentTime.weekDay),
                weatherResponse.getForecasts().get(2).getDate(),
                weatherResponse.getForecasts().get(2).getParts().getDayShort()));
        threeDaysWIAdapter=new ThreeDaysWIAdapter(dayList);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_today_weather_info, container, false);
        recyclerView=view.findViewById(R.id.recyclerViewTWI);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(threeDaysWIAdapter);
        return view;
    }
}
