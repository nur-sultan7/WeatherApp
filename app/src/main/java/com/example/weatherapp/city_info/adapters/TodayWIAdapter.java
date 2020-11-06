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
import com.example.weatherapp.data.WeatherInfo;
import com.example.weatherapp.pojo.Hour;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYouListener;

public class TodayWIAdapter extends RecyclerView.Adapter<TodayWIAdapter.TodayWIHolder>  {
    private Today today;
    private Context context;

    public TodayWIAdapter(Context context, Today today) {
        this.today = today;
        this.context=context;
    }

    @NonNull
    @Override
    public TodayWIHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_today_wi,parent,false);
        return new TodayWIHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodayWIHolder holder, int position) {
        Hour hour = today.getHoursList().get(position);
        holder.textViewTWIName.setText(today.getTime(position));
        holder.textViewTWICondition.setText(WeatherInfo.getConditionInRussian(hour.getCondition()));
        String temp;
        if (hour.getTemp()>0)
            temp="+%s";
        else
            temp="%s";
        holder.textViewTWITemp.setText(String.format(temp,hour.getTemp()));
        holder.textViewTWIWindSpeed.setText(String.format("%s м/с",hour.getWindSpeed()));
        holder.textViewTWIDir.setText(WeatherInfo.getWindInfoListInRussian(hour.getWindDir()));
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
                .load(Uri.parse(WeatherInfo.getWeatherIcon(hour.getIcon())), holder.imageViewTWIIcon);
    }

    @Override
    public int getItemCount() {
        return today.getHoursList().size();
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
            imageViewTWIIcon=itemView.findViewById(R.id.imageViewTDWIIcon);
            textViewTWIName=itemView.findViewById(R.id.textViewTDWIName);
            textViewTWICondition=itemView.findViewById(R.id.textViewTDWICondition);
            textViewTWITemp=itemView.findViewById(R.id.textViewTDWITemp);
            textViewTWIWindSpeed=itemView.findViewById(R.id.textViewTDWIWindSpeed);
            textViewTWIDir=itemView.findViewById(R.id.textViewTDWIDir);
        }
    }
}
