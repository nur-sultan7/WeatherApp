package com.example.weatherapp.city_info.data;

import com.example.weatherapp.pojo.DayShort;
import com.example.weatherapp.pojo.PartOfDay;

public class Day {
    private String name;
    private String data;
    private DayShort dayShort;

    public Day(String name, String data, DayShort dayShort) {
        this.name = name;
        this.data = data;
        this.dayShort = dayShort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public DayShort getDayShort() {
        return dayShort;
    }

    public void setDayShort(DayShort dayShort) {
        this.dayShort = dayShort;
    }
}
