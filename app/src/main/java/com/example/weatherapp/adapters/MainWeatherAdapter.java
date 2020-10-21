package com.example.weatherapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.R;
import com.example.weatherapp.pojo.WeatherResponse;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainWeatherAdapter extends RecyclerView.Adapter<MainWeatherAdapter.MainWeatherViewHolder>  {
    List<WeatherResponse> weatherResponseList;

    public MainWeatherAdapter() {
        this.weatherResponseList = new ArrayList<>();
    }

    public void setWeatherResponseList(List<WeatherResponse> weatherResponseList) {
        this.weatherResponseList = weatherResponseList;
    }

    @NonNull
    @Override
    public MainWeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_weather,parent,false);
        return new MainWeatherViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MainWeatherViewHolder holder, int position) {
        WeatherResponse weatherResponse = weatherResponseList.get(position);
        holder.cityName.setText(weatherResponse.getInfo().getTzinfo().getName());
        Picasso.get()
                .load(weatherResponse.getFact().getWeatherIcon())
                .into(holder.cityWeatherIcon);
}

    @Override
    public int getItemCount() {
        return weatherResponseList.size();
    }

    static class MainWeatherViewHolder extends RecyclerView.ViewHolder
    {
        ImageView cityWeatherIcon;
        TextView cityName;
         public MainWeatherViewHolder(@NonNull View itemView) {
            super(itemView);
            cityWeatherIcon=itemView.findViewById(R.id.imageViewWeatherIcon);
            cityName=itemView.findViewById(R.id.textViewCityName);
        }
    }
}
