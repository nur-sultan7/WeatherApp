package com.example.weatherapp.city_info.fragmets;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.MainViewModel;
import com.example.weatherapp.R;
import com.example.weatherapp.city_info.adapters.TomorrowWIAdapter;
import com.example.weatherapp.city_info.data.Today;
import com.example.weatherapp.city_info.data.Tomorrow;
import com.example.weatherapp.pojo.Parts;
import com.example.weatherapp.pojo.WeatherResponse;

import java.util.ArrayList;
import java.util.List;


public class TomorrowWeatherInfoFragment extends Fragment {

    private static final String ARG_PARAM1 = "city_info";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private RecyclerView recyclerView;
    private MainViewModel viewModel;
    private WeatherResponse weatherResponse;
    private Parts partsOfDay;
    private List<Tomorrow> tomorrowList;
    private TomorrowWIAdapter tomorrowWIAdapter;

    public TomorrowWeatherInfoFragment() {
        // Required empty public constructor
    }


    public static TomorrowWeatherInfoFragment newInstance(String param1) {
        TomorrowWeatherInfoFragment fragment = new TomorrowWeatherInfoFragment();
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
        partsOfDay = weatherResponse.getForecasts().get(1).getParts();
        tomorrowList =new ArrayList<>();
        tomorrowList.add( new Tomorrow(partsOfDay.getMorning(),"Утро"));
        tomorrowList.add(new Tomorrow(partsOfDay.getDay(),"День"));
        tomorrowList.add(new Tomorrow(partsOfDay.getEvening(),"Вечер"));
        tomorrowList.add(new Tomorrow(partsOfDay.getNight(),"Ночь"));
        tomorrowWIAdapter =new TomorrowWIAdapter(getContext(), tomorrowList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_today_weather_info, container, false);
        recyclerView=view.findViewById(R.id.recyclerViewTWI);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(tomorrowWIAdapter);
        return view;
    }
}
