package com.example.weatherapp.city_info.adapters;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.R;
import com.example.weatherapp.city_info.data.Day;
import com.example.weatherapp.data.WeatherInfo;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;

import java.util.List;

public class ThreeDaysWIAdapter extends RecyclerView.Adapter<ThreeDaysWIAdapter.ThreeDaysVH> {
    private List<Day> list;

    public ThreeDaysWIAdapter(List<Day> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ThreeDaysVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_three_days_wi,parent,false);
        return new ThreeDaysVH(view);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onBindViewHolder(@NonNull ThreeDaysVH holder, int position) {
        Day day = list.get(position);
        holder.textViewDay.setText(day.getName());

        holder.textViewDayDate.setText(String.format(day.getMonthAndDay()));
        holder.textViewWindSpeed.setText(String.format("%s м/с",day.getDayShort().getWindSpeed()));
        holder.textViewTemp.setText(String.format("%+d",day.getDayShort().getTemp()));
        holder.textViewCondition.setText(WeatherInfo.getConditionInRussian(day.getDayShort().getCondition()));
        holder.textViewHumidity.setText(String.format("%s%%",day.getDayShort().getHumidity()));
        GlideToVectorYou.init()
                .load(Uri.parse(WeatherInfo.getWeatherIcon(day.getDayShort().getIcon())),holder.imageViewIcon);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ThreeDaysVH extends RecyclerView.ViewHolder{
        TextView textViewDay;
        TextView textViewDayDate;
        TextView textViewWindSpeed;
        TextView textViewHumidity;
        TextView textViewCondition;
        TextView textViewTemp;
        ImageView imageViewIcon;

        public ThreeDaysVH(@NonNull View itemView) {
            super(itemView);
            textViewDay=itemView.findViewById(R.id.textViewTDWIName);
            textViewDayDate=itemView.findViewById(R.id.textViewTDWIDate);
            textViewWindSpeed=itemView.findViewById(R.id.textViewTDWIWindSpeed);
            textViewHumidity =itemView.findViewById(R.id.textViewTDWIHumidity);
            textViewCondition=itemView.findViewById(R.id.textViewTDWICondition);
            textViewTemp=itemView.findViewById(R.id.textViewTDWITemp);
            imageViewIcon=itemView.findViewById(R.id.imageViewTDWIIcon);
        }
    }
}
