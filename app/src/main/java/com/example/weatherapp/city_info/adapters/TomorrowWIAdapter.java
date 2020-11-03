package com.example.weatherapp.city_info.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.R;
import com.example.weatherapp.city_info.data.Today;
import com.example.weatherapp.city_info.data.Tomorrow;
import com.example.weatherapp.data.WeatherInfo;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYouListener;

import java.util.List;

public class TomorrowWIAdapter extends RecyclerView.Adapter<TomorrowWIAdapter.TodayWIHolder>  {
    private List<Tomorrow> tomorrowList;
    private Context context;
    private WeatherInfo weatherInfo;

    public TomorrowWIAdapter(Context context, List<Tomorrow> tomorrowList) {
        this.tomorrowList = tomorrowList;
        this.context=context;
        weatherInfo=new WeatherInfo();
    }

    @NonNull
    @Override
    public TodayWIHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tomorrow_wi,parent,false);
        return new TodayWIHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodayWIHolder holder, int position) {
        Tomorrow today = tomorrowList.get(position);
        holder.textViewTWIName.setText(today.getName());
        holder.textViewTWICondition.setText(weatherInfo.getConditionInRussian(today.getPartOfDay().getCondition()));
        String temp;
        if (today.getPartOfDay().getTempAvg()>0)
            temp="+%s";
        else
            temp="%s";
        holder.textViewTWITemp.setText(String.format(temp,today.getPartOfDay().getTempAvg()));
        holder.textViewTWIWindSpeed.setText(String.format("%s м/с",today.getPartOfDay().getWindSpeed()));
        holder.textViewTWIDir.setText(weatherInfo.getWindInfoListInRussian(today.getPartOfDay().getWindDir()));
        GlideToVectorYou
                .init()
                .with(context)
                .withListener(new GlideToVectorYouListener() {
                    @Override
                    public void onLoadFailed() {
                    }
                    @Override
                    public void onResourceReady() {
                    }
                })
                //.setPlaceHolder(placeholderLoading, placeholderError)
                .load(Uri.parse(today.getWeatherIcon()), holder.imageViewTWIIcon);
    }

    @Override
    public int getItemCount() {
        return tomorrowList.size();
    }

    class TodayWIHolder extends RecyclerView.ViewHolder
    {
        ImageView imageViewTWIIcon;
        TextView textViewTWIName;
        TextView textViewTWICondition;
        TextView textViewTWITemp;
        TextView textViewTWIWindSpeed;
        TextView textViewTWIDir;
        public TodayWIHolder(@NonNull View itemView) {
            super(itemView);
            imageViewTWIIcon=itemView.findViewById(R.id.imageViewTWIIcon);
            textViewTWIName=itemView.findViewById(R.id.textViewTWIName);
            textViewTWICondition=itemView.findViewById(R.id.textViewTWICondition);
            textViewTWITemp=itemView.findViewById(R.id.textViewTWITemp);
            textViewTWIWindSpeed=itemView.findViewById(R.id.textViewTWIWindSpeed);
            textViewTWIDir=itemView.findViewById(R.id.textViewTWIDir);
        }
    }
}
