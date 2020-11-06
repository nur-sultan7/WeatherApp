package com.example.weatherapp.city_info.data;

import android.annotation.SuppressLint;

import com.example.weatherapp.pojo.DayShort;
import com.example.weatherapp.pojo.PartOfDay;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Day {
    private String name;
    private Date date;
    private DayShort dayShort;


    public Day(String name, String date, DayShort dayShort)  {
        this.name = name;
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.date = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.dayShort = dayShort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getData() {
       // SimpleDateFormat formatter4=new SimpleDateFormat("E, MMM dd yyyy");
        return date;
    }
    public String getMonthAndDay()
    {
        return new SimpleDateFormat("d MMM").format(date);
    }


    public DayShort getDayShort() {
        return dayShort;
    }

    public void setDayShort(DayShort dayShort) {
        this.dayShort = dayShort;
    }
}
