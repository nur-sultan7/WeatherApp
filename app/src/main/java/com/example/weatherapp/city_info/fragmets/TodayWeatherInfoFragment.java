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
import com.example.weatherapp.city_info.adapters.TodayWIAdapter;
import com.example.weatherapp.city_info.data.Today;
import com.example.weatherapp.pojo.WeatherResponse;

import java.util.ArrayList;
import java.util.List;


public class TodayWeatherInfoFragment extends Fragment {

    private static final String ARG_PARAM1 = "city_info";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private RecyclerView recyclerView;
    private MainViewModel viewModel;
    private WeatherResponse weatherResponse;
    private Today today;
    private List<Today> todayList;
    private TodayWIAdapter todayWIAdapter;

    public TodayWeatherInfoFragment() {
        // Required empty public constructor
    }


    public static TodayWeatherInfoFragment newInstance(String param1) {
        TodayWeatherInfoFragment fragment = new TodayWeatherInfoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
          //  mParam2 = getArguments().getString(ARG_PARAM2);
        }
        viewModel= ViewModelProviders.of(this).get(MainViewModel.class);
        weatherResponse=viewModel.getWeatherCityByInfo(mParam1);
        today=new Today();
        today.setHourList(weatherResponse.getForecasts().get(0).getHours());
        todayList=new ArrayList<>();
        todayWIAdapter=new TodayWIAdapter(getContext(),today);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_today_weather_info, container, false);
        recyclerView=view.findViewById(R.id.recyclerViewTWI);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(todayWIAdapter);
        return view;
    }
}
