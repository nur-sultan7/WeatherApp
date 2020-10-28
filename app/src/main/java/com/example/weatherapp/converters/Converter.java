package com.example.weatherapp.converters;

import androidx.room.TypeConverter;

import com.example.weatherapp.pojo.Fact;
import com.example.weatherapp.pojo.Forecast;
import com.example.weatherapp.pojo.Info;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    @TypeConverter
    public String getInfoAsString(Info info)
    {
        return new Gson().toJson(info);
    }
    @TypeConverter
    public Info getStringAsInfo(String infoString)
    {
        Gson gson = new Gson();
        Info info = gson.fromJson(infoString,Info.class);
        return info;
    }
    @TypeConverter
    public String getFactAsString(Fact fact)
    {
        return new Gson().toJson(fact);
    }
    @TypeConverter
    public Fact getStringAsFact(String factString)
    {
        Gson gson = new Gson();
        Fact fact = gson.fromJson(factString,Fact.class);
        return fact;
    }
    @TypeConverter
    public String getForecastListAsString(List<Forecast> forecastList)
    {
        return new Gson().toJson(forecastList);
    }
    @TypeConverter
    public List<Forecast> getStringAsForecastList(String forecastString)
    {
        Gson gson = new Gson();
        ArrayList arrayList = gson.fromJson(forecastString,ArrayList.class);
        ArrayList<Forecast> list = new ArrayList<>();
        for (Object o: arrayList)
        {
            Forecast forecast = gson.fromJson(o.toString(),Forecast.class);
            list.add(forecast);
        }
        return list;
    }
}
