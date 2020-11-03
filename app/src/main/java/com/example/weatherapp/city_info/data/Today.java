package com.example.weatherapp.city_info.data;

import android.annotation.SuppressLint;

import com.example.weatherapp.pojo.Hour;


import java.util.List;


public class Today {
private List<Hour> hoursList;
private String time;



    public String getTime(int position) {
        return String.format("%02d:00",position);
    }

    public List<Hour> getHoursList() {
        return hoursList;
    }

    public void setHourList(List<Hour> hourList) {
        this.hoursList = hourList;
    }


}
