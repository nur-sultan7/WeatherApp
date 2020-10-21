package com.example.weatherapp.adapters;

import android.app.Activity;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.R;
import com.example.weatherapp.pojo.WeatherResponse;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYouListener;


import java.util.ArrayList;
import java.util.List;

public class MainWeatherAdapter extends RecyclerView.Adapter<MainWeatherAdapter.MainWeatherViewHolder>  {
    List<WeatherResponse> weatherResponseList;
    Activity activity;

    public MainWeatherAdapter(Activity activity) {
        this.weatherResponseList = new ArrayList<>();
        this.activity=activity;
    }

    public void setWeatherResponseList(List<WeatherResponse> weatherResponseList) {
        this.weatherResponseList = weatherResponseList;
        notifyDataSetChanged();
    }
    public void addItemToWeatherResponseList(WeatherResponse weatherResponse)
    {
        weatherResponseList.add(weatherResponse);
        notifyDataSetChanged();
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
        String iconWeatherString= weatherResponse.getFact().getWeatherIcon();
        GlideToVectorYou
                .init()
                .with(activity)
                .withListener(new GlideToVectorYouListener() {
                    @Override
                    public void onLoadFailed() {
                        Toast.makeText(activity, "Load failed", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onResourceReady() {
                        Toast.makeText(activity, "Image ready", Toast.LENGTH_SHORT).show();
                    }
                })
                //.setPlaceHolder(placeholderLoading, placeholderError)
                .load(Uri.parse(iconWeatherString), holder.cityWeatherIcon);

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
