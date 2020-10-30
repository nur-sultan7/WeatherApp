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
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou;
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYouListener;

import java.util.ArrayList;
import java.util.List;

public class TodayWIAdapter extends RecyclerView.Adapter<TodayWIAdapter.TodayWIHolder>  {
    private List<Today> todayList ;
    private Context context;

    public TodayWIAdapter(Context context, List<Today> todayList) {
        this.todayList = todayList;
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
        Today today = todayList.get(position);
        holder.textViewTWIName.setText(today.getName());
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
        return todayList.size();
    }

    class TodayWIHolder extends RecyclerView.ViewHolder
    {
        ImageView imageViewTWIIcon;
        TextView textViewTWIName;
        public TodayWIHolder(@NonNull View itemView) {
            super(itemView);
            imageViewTWIIcon=itemView.findViewById(R.id.imageViewTWIIcon);
            textViewTWIName=itemView.findViewById(R.id.textViewTWIName);
        }
    }
}
