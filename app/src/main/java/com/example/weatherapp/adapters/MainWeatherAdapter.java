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
import com.example.weatherapp.data.WeatherInfo;
import com.example.weatherapp.pojo.WeatherResponse;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYouListener;


import java.util.ArrayList;
import java.util.List;

public class MainWeatherAdapter extends RecyclerView.Adapter<MainWeatherAdapter.MainWeatherViewHolder>  {
    List<WeatherResponse> weatherResponseList;
    private static WeatherInfo weatherInfo;
    Activity activity;
    private boolean isToday;
    private static String weatherIcon= "https://yastatic.net/weather/i/icons/blueye/color/svg/%s.svg";



    public MainWeatherAdapter(Activity activity) {
        this.weatherResponseList = new ArrayList<>();
        this.activity=activity;
        weatherInfo=new WeatherInfo();

    }
    public String getWeatherIcon(String icon) {
        return String.format(weatherIcon,icon);
    }

    public void setToday(boolean today) {
        isToday = today;
        notifyDataSetChanged();
    }


    public void setWeatherResponseList(List<WeatherResponse> weatherResponseList, boolean isToday) {
        this.weatherResponseList = weatherResponseList;
        this.isToday=isToday;
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
    public void onBindViewHolder(@NonNull final MainWeatherViewHolder holder, int position) {
        WeatherResponse weatherResponse = weatherResponseList.get(position);
        holder.cityName.setText(weatherResponse.getInfo().getTzinfo().getName());
        String condition = isToday? weatherInfo.getConditionInRussian(weatherResponse.getFact().getCondition())
                :weatherInfo.getConditionInRussian(weatherResponse.getForecasts().get(0).getParts().getDayShort().getCondition());
        holder.cityCondition.setText(condition);
        int temp =isToday? weatherResponse.getFact().getTemp(): weatherResponse.getForecasts().get(0).getParts().getDayShort().getTemp();
        String tempString;
        if (temp>0)
            tempString="+"+temp;
        else
            tempString= String.valueOf(temp);
        holder.cityTemp.setText(tempString);
        String iconWeatherString=isToday? getWeatherIcon(weatherResponse.getFact().getIcon()):getWeatherIcon( weatherResponse.getForecasts().get(0).getParts().getDayShort().getIcon());
        GlideToVectorYou
                .init()
                .with(activity)
                .withListener(new GlideToVectorYouListener() {
                    @Override
                    public void onLoadFailed() {
                    

                    }

                    @Override
                    public void onResourceReady() {

                    }
                })
                //.setPlaceHolder(placeholderLoading, placeholderError)
                .load(Uri.parse(iconWeatherString), holder.cityWeatherIcon)

        ;

    }

    @Override
    public int getItemCount() {
        return weatherResponseList.size();
    }

    static class MainWeatherViewHolder extends RecyclerView.ViewHolder
    {
        ImageView cityWeatherIcon;
        TextView cityName;
        TextView cityTemp;
        TextView cityCondition;
         public MainWeatherViewHolder(@NonNull View itemView) {
            super(itemView);
            cityWeatherIcon=itemView.findViewById(R.id.imageViewWeatherIcon);
            cityName=itemView.findViewById(R.id.textViewCityName);
            cityTemp=itemView.findViewById(R.id.textViewTemp);
            cityCondition=itemView.findViewById(R.id.textViewCondition);
        }
    }
}
