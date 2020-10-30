package com.example.weatherapp.city_info.data;

import com.example.weatherapp.pojo.PartOfDay;

public class Today {
private PartOfDay partOfDay;
private String name;
private String weatherIcon= "https://yastatic.net/weather/i/icons/blueye/color/svg/%s.svg";

    public Today(PartOfDay partOfDay, String name) {
        this.partOfDay = partOfDay;
        this.name = name;
    }

    public PartOfDay getPartOfDay() {
        return partOfDay;
    }

    public void setPartOfDay(PartOfDay partOfDay) {
        this.partOfDay = partOfDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  String getWeatherIcon() {
        return String.format(weatherIcon, partOfDay.getIcon());
    }
}
