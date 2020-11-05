package com.example.weatherapp.city_info.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.R;
import com.example.weatherapp.city_info.data.Day;

import java.util.List;

public class ThreeDaysWIAdapter extends RecyclerView.Adapter<ThreeDaysWIAdapter.ThreeDaysVH> {
    private List<Day> list;

    public ThreeDaysWIAdapter(List<Day> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ThreeDaysVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tomorrow_wi,parent,false);
        return new ThreeDaysVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThreeDaysVH holder, int position) {
        Day day = list.get(position);
        holder.textViewDay.setText(day.getName());
        holder.textViewDayDate.setText(day.getData());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ThreeDaysVH extends RecyclerView.ViewHolder{
        TextView textViewDay;
        TextView textViewDayDate;
        TextView textViewWindSpeed;
        TextView textViewWindDirection;
        TextView textViewCondition;
        TextView textViewTemp;
        ImageView imageViewIcon;

        public ThreeDaysVH(@NonNull View itemView) {
            super(itemView);
            textViewDay=itemView.findViewById(R.id.textViewTWIName);
            textViewDayDate=itemView.findViewById(R.id.textViewTWIDate);
            textViewWindSpeed=itemView.findViewById(R.id.textViewTWIWindSpeed);
            textViewWindDirection=itemView.findViewById(R.id.textViewTWIDir);
            textViewCondition=itemView.findViewById(R.id.textViewTWICondition);
            textViewTemp=itemView.findViewById(R.id.textViewTWITemp);
            imageViewIcon=itemView.findViewById(R.id.imageViewTWIIcon);
        }
    }
}
