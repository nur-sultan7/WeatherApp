package com.example.weatherapp.city_info.fragmets;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.weatherapp.MainViewModel;
import com.example.weatherapp.R;
import com.example.weatherapp.city_info.adapters.ThreeDaysWIAdapter;
import com.example.weatherapp.city_info.data.Day;
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
        dayList.add(new Day("сегодня",
                weatherResponse.getForecasts().get(0).getDate(),
                weatherResponse.getForecasts().get(0).getParts().getDayShort()));
        dayList.add(new Day("Завтра",
                weatherResponse.getForecasts().get(1).getDate(),
                weatherResponse.getForecasts().get(1).getParts().getDayShort()));
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
